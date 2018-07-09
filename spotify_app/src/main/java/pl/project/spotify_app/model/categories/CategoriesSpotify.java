package pl.project.spotify_app.model.categories;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoriesSpotify {
	
	@JsonProperty("categories")
	private Categories categories;
	
	public CategoriesSpotify() {}
	
	public CategoriesSpotify(Categories categories) {
		super();
		this.categories = categories;
	}

	public Categories getCategories() {
		return categories;
	}

	public void setCategories(Categories categories) {
		this.categories = categories;
	}
}
