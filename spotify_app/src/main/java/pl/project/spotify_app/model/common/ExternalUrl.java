package pl.project.spotify_app.model.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExternalUrl {

	@JsonProperty("spotify")
	private String spotify;
}
