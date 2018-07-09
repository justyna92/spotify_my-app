package pl.project.spotify_app.model.playlists;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Track {

	@JsonProperty("href")
	private String href;
	
	@JsonProperty("total")
	private int total;
	
	
}
