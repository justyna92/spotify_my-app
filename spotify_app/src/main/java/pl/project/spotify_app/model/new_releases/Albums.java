package pl.project.spotify_app.model.new_releases;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Albums {
	
	@JsonProperty("href")
	private String href;
	
	@JsonProperty("items")
	private ItemAlbum[] itemsAlbums;
	
	@JsonProperty("limit")
	private int limit;
	
	@JsonProperty("next")
	private String next;
	
	@JsonProperty("offset")
	private int offset;
	
	@JsonProperty("previous")
	private String previous;
	
	@JsonProperty("total")
	private int total;

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public ItemAlbum[] getItemsAlbums() {
		return itemsAlbums;
	}

	public void setItemsAlbums(ItemAlbum[] itemsAlbums) {
		this.itemsAlbums = itemsAlbums;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public String getNext() {
		return next;
	}

	public void setNext(String next) {
		this.next = next;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public String getPrevious() {
		return previous;
	}

	public void setPrevious(String previous) {
		this.previous = previous;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	
	
}
