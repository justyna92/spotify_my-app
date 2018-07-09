package pl.project.spotify_app.model.featuredPlaylists;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import pl.project.spotify_app.model.playlists.Playlists;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FeaturedPlaylists {
	
	@JsonProperty("message")
	private String message;
	
	@JsonProperty("playlists")
	private Playlists playlists;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Playlists getPlaylists() {
		return playlists;
	}

	public void setPlaylists(Playlists playlists) {
		this.playlists = playlists;
	}
	
}
