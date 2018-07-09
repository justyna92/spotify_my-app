package pl.project.spotify_app.model.playlists;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import pl.project.spotify_app.model.common.ExternalUrl;
import pl.project.spotify_app.model.common.Image;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemPlaylist {

	@JsonProperty("collaborative")
	private boolean collaborative;
	
	@JsonProperty("external_urls")
	private ExternalUrl externalUrl;
	
	@JsonProperty("href")
	private String href;
	
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("images")
	private Image[] images;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("owner")
	private Owner owner;
	
	@JsonProperty("public")
	private Boolean isPublic;
	
	@JsonProperty("snapshot_id")
	private String snapshot_id;
	
	@JsonProperty("tracks")
	private Track tracks;
	
	@JsonProperty("type")
	private String type;
	
	@JsonProperty("uri")
	private String uri;

	public boolean isCollaborative() {
		return collaborative;
	}

	public void setCollaborative(boolean collaborative) {
		this.collaborative = collaborative;
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

	public Image[] getImages() {
		return images;
	}

	public void setImages(Image[] images) {
		this.images = images;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public Boolean getIsPublic() {
		return isPublic;
	}

	public void setIsPublic(Boolean isPublic) {
		this.isPublic = isPublic;
	}

	public String getSnapshot_id() {
		return snapshot_id;
	}

	public void setSnapshot_id(String snapshot_id) {
		this.snapshot_id = snapshot_id;
	}

	public Track getTracks() {
		return tracks;
	}

	public void setTracks(Track tracks) {
		this.tracks = tracks;
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
