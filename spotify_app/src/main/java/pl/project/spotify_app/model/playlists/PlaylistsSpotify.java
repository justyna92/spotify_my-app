package pl.project.spotify_app.model.playlists;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlaylistsSpotify {
	
	@JsonProperty("playlists")
	private Playlists playlists;
	
	public PlaylistsSpotify() {}
	
	public PlaylistsSpotify(Playlists playlists) {
		super();
		this.playlists = playlists;
	}

	public Playlists getPlaylists() {
		return playlists;
	}

	public void setPlaylists(Playlists playlists) {
		this.playlists = playlists;
	}
}
