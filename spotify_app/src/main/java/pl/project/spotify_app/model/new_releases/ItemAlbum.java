package pl.project.spotify_app.model.new_releases;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import pl.project.spotify_app.model.common.ExternalUrl;
import pl.project.spotify_app.model.common.Image;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemAlbum {

	@JsonProperty("album_type")
	private String albumType;
	
	@JsonProperty("artists")
	private Artist[] artists;
	
	@JsonProperty("available_markets")
	private String[] availableMarkets;
	
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
	
	@JsonProperty("type")
	private String type;
	
	@JsonProperty("uri")
	private String uri;

	public String getAlbumType() {
		return albumType;
	}

	public void setAlbumType(String albumType) {
		this.albumType = albumType;
	}

	public Artist[] getArtists() {
		return artists;
	}

	public void setArtists(Artist[] artists) {
		this.artists = artists;
	}

	public String[] getAvailableMarkets() {
		return availableMarkets;
	}

	public void setAvailableMarkets(String[] availableMarkets) {
		this.availableMarkets = availableMarkets;
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
