package pl.project.spotify_app.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import pl.project.spotify_app.model.Token;

@Service
public class HttpRequestService {

	public static HttpEntity<String> setEntityToAccessData(Token token) {
		
		HttpHeaders header = new HttpHeaders();
		header.set("Authorization", token.getTokenType() + " " + token.getAccessToken());
		
		return new HttpEntity<String>(header);
	}
}
