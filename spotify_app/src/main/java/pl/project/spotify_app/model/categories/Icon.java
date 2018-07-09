package pl.project.spotify_app.model.categories;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Icon {

	@JsonProperty("height")
	private int height;
	
	@JsonProperty("url")
	private String url;
	
	@JsonProperty("width")
	private int width;
	
	public Icon() {}
	
	public Icon(int height, String url, int width) {
		super();
		this.height = height;
		this.url = url;
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	
	
}
