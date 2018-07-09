package pl.project.spotify_app.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import pl.project.spotify_app.model.Authorization;
import pl.project.spotify_app.model.Token;

@Controller
public class AuthorizationController {

	private static final String loginAddress = Authorization.getLoggingAddress();
	private static final String urlToReceiveToken = Authorization.getUrlToReceiveToken();
	@Autowired
	private Token token;
	
	@RequestMapping("/")
	public String logIn(Map<String, Object> model) {
		
		return "redirect:" + loginAddress;
	}
	
	@GetMapping("/home")
	public String showPageAfterLogging(@RequestParam(value = "code", required = false) String code,
			@RequestParam(value = "error", required = false) String error, Model model) throws InterruptedException {
	
		String authorizationCode = code;
		if(authorizationCode != null) {
			
			this.token = getInitialToken(authorizationCode);
			if(this.token.getAccessToken() == null)
				model.addAttribute("error", "This application encountered client-side HTTP errors.");
		}		
		else
			model.addAttribute("error", error);
					
		return "homePage";
	}
	
	private Token refreshToken(HttpEntity<MultiValueMap<String, String>> entity) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		try {
			
			ResponseEntity<Token> responseJson = restTemplate.exchange(urlToReceiveToken, HttpMethod.POST, entity, Token.class);
            
			this.token.setAccessToken(responseJson.getBody().getAccessToken());
			this.token.setExpiresIn(responseJson.getBody().getExpiresIn());
			this.token.setScope(responseJson.getBody().getScope());
			this.token.setTokenType(responseJson.getBody().getTokenType());
			
			if(responseJson.getBody().getRefreshToken() != null)
				this.token.setRefreshToken(responseJson.getBody().getRefreshToken());
			
			return this.token;
					
        } catch(RestClientException ex) {
        	
        	return this.token;
        }	
	}
	
	private HttpEntity<MultiValueMap<String, String>> setHttpEntity(MultiValueMap<String, String> bodyParameters) {
		
		HttpHeaders headerParameters = new HttpHeaders();
		headerParameters.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		
        return new HttpEntity<MultiValueMap<String, String>>(bodyParameters, headerParameters);        
	}
	
	private Token getInitialToken(String authorizationCode) throws InterruptedException {
		
		MultiValueMap<String, String> bodyParameters = new LinkedMultiValueMap<String, String>();
		bodyParameters.add("grant_type", "authorization_code");
		bodyParameters.add("code", authorizationCode);
		bodyParameters.add("redirect_uri", Authorization.getRedirectUri());
		bodyParameters.add("client_id", Authorization.getClientId());
		bodyParameters.add("client_secret", Authorization.getClientSecret());
        
		HttpEntity<MultiValueMap<String, String>> entity = this.setHttpEntity(bodyParameters);
		
        return this.refreshToken(entity);
	}
	
	@Scheduled(fixedDelay = 3600 * 1000 / 2)
	public void sendRequestForRefreshingToken() {
		
		if(this.token.getAccessToken() != null) {
			MultiValueMap<String, String> bodyParameters = new LinkedMultiValueMap<String, String>();
			bodyParameters.add("grant_type", "refresh_token");
			bodyParameters.add("refresh_token", this.token.getRefreshToken());
			bodyParameters.add("client_id", Authorization.getClientId());
			bodyParameters.add("client_secret", Authorization.getClientSecret());
	        		
	        this.token = this.refreshToken(this.setHttpEntity(bodyParameters));
		}
	}
	
}
