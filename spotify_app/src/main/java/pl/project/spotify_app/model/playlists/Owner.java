package pl.project.spotify_app.model.playlists;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import pl.project.spotify_app.model.common.ExternalUrl;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Owner {

	@JsonProperty("display_name")
	private String displayName;
	
	@JsonProperty("external_urls")
	private ExternalUrl externalUrl;
	
	@JsonProperty("href")
	private String href;
	
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("type")
	private String type;
	
	@JsonProperty("uri")
	private String uri;

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public ExternalUrl getExternalUrl() {
		return externalUrl;
	}

	public void setExternalUrl(ExternalUrl externalUrl) {
		this.externalUrl = externalUrl;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}
	
	
}
