package pl.project.spotify_app.model;

public abstract class Authorization {

	private static final String baseAddress = "https://accounts.spotify.com/authorize?";
	private static final String clientId = "cb803462ff7c472ba262eb105eadca37";
	private static final String responseType = "code";
	private static final String scope = "user-read-birthdate user-read-email";
	private static final String redirectUri = "http://127.0.0.1:8181/home";
	private static final String clientSecret = "acddad9d8fd14291a7b9ae561da69e04";
	private static final String urlToReceiveToken = "https://accounts.spotify.com/api/token";
	
	public static String getLoggingAddress() {
		
		return baseAddress + "client_id=" + clientId + "&" 
				+ "response_type=" + responseType + "&"
				+ "scope=" + scope + "&"
				+ "redirect_uri=" + redirectUri;
	}
	
	public static String getClientId() {
		return clientId;
	}
	
	public static String getClientSecret() {
		return clientSecret;
	}
	
	public static String getRedirectUri() {
		return redirectUri;
	}
	
	public static String getUrlToReceiveToken() {
		return urlToReceiveToken;
	}
	
}
