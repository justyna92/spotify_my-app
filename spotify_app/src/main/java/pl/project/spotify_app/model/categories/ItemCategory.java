package pl.project.spotify_app.model.categories;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemCategory {

	@JsonProperty("href")
	private String href;
	
	@JsonProperty("icons")
	private Icon[] icons;
	
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("name")
	private String name;
	
	public ItemCategory() {}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public Icon[] getIcons() {
		return icons;
	}

	public void setIcons(Icon[] icons) {
		this.icons = icons;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
