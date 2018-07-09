package pl.project.spotify_app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pl.project.spotify_app.model.Token;
import pl.project.spotify_app.model.categories.CategoriesSpotify;
import pl.project.spotify_app.model.categories.ItemCategory;
import pl.project.spotify_app.model.featuredPlaylists.FeaturedPlaylists;
import pl.project.spotify_app.model.new_releases.ItemAlbum;
import pl.project.spotify_app.model.new_releases.NewReleasesSpotify;
import pl.project.spotify_app.model.playlists.ItemPlaylist;
import pl.project.spotify_app.model.playlists.PlaylistsSpotify;
import pl.project.spotify_app.service.HttpRequestService;

@Controller
public class MusicController {

	@Autowired
	private Token token;
	
	private List<ItemCategory> categoriesList =  new ArrayList<ItemCategory>();
	private List<ItemPlaylist> categoryPlaylists = new ArrayList<ItemPlaylist>();
	private List<ItemAlbum> newReleasesList = new ArrayList<ItemAlbum>();
	private List<FeaturedPlaylists> featuredPlaylists = new ArrayList<FeaturedPlaylists>();
	
	
	@GetMapping("/featured-playlists")
	public String showFeaturedPlaylists(Model model) {
		model.addAttribute("featuredPlaylists", this.featuredPlaylists);
		return "featuredPlaylistsPage";
	}
	
	@GetMapping("/load-featured-playlists")
	private String getListOfFeaturedPlaylists(RedirectAttributes ra) {
		
		this.removeAllFromList(this.featuredPlaylists);

		String url = "https://api.spotify.com/v1/browse/featured-playlists";
		HttpEntity<String> entity  = HttpRequestService.setEntityToAccessData(this.token);
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<FeaturedPlaylists> responseJson = null;
		FeaturedPlaylists featuredPlaylists = null;
		
		do {
			try {
				
				responseJson = restTemplate.exchange(url, HttpMethod.GET, entity, FeaturedPlaylists.class);
				featuredPlaylists = responseJson.getBody();
				this.featuredPlaylists.add(featuredPlaylists);
				url = responseJson.getBody().getPlaylists().getNext();

			} catch(RestClientException ex) {
				ra.addAttribute("error", ex.getMessage());
				ra.addFlashAttribute("error", ex.getMessage());
				return "redirect:featured-playlists";
			}
		} while(url != null);

		return "redirect:featured-playlists";
	}
	
	@GetMapping("/new-releases")
	public String showNewReleases(Model model) {
		
		model.addAttribute("newReleasesList", this.newReleasesList);
		return "newReleasesPage";
	}
	
	@GetMapping("/load-new-releases")
	private String getListOfNewReleases(RedirectAttributes ra) {
				
		this.removeAllFromList(this.newReleasesList);

		String url = "https://api.spotify.com/v1/browse/new-releases";
		HttpEntity<String> entity  = HttpRequestService.setEntityToAccessData(this.token);
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<NewReleasesSpotify> responseJson = null;
		ItemAlbum[] newReleases = null;
		
		do {
			try {
				
				responseJson = restTemplate.exchange(url, HttpMethod.GET, entity, NewReleasesSpotify.class);
				newReleases = responseJson.getBody().getAlbums().getItemsAlbums();
				for(ItemAlbum item : newReleases) {
					this.newReleasesList.add(item);
				}
				url = responseJson.getBody().getAlbums().getNext();
				
			} catch(RestClientException ex) {
				ra.addAttribute("error", ex.getMessage());
				ra.addFlashAttribute("error", ex.getMessage());
				return "redirect:new-releases";
			}
		} while(url != null);

		return "redirect:new-releases";
	}
	
	@GetMapping("/categories")
	public String showCategories(Model model) {
		
		model.addAttribute("categoriesList", this.categoriesList);
		return "categoriesPage";
	}
	
	@GetMapping("/load-categories")
	private String getListOfCategory(RedirectAttributes ra) {
				
		this.removeAllFromList(this.categoriesList);

		String url = "https://api.spotify.com/v1/browse/categories";
		HttpEntity<String> entity  = HttpRequestService.setEntityToAccessData(this.token);
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<CategoriesSpotify> responseJson = null;
		ItemCategory[] categories = null;
		
		do {
			try {
			
				responseJson = restTemplate.exchange(url, HttpMethod.GET, entity, CategoriesSpotify.class);
				categories = responseJson.getBody().getCategories().getItemsCategories();
				for(ItemCategory item : categories) {
					this.categoriesList.add(item);
				}
				url = responseJson.getBody().getCategories().getNext();
				
			} catch(RestClientException ex) {
				ra.addAttribute("error", ex.getMessage());
				ra.addFlashAttribute("error", ex.getMessage());
				return "redirect:categories";
			}
		} while(url != null);

		return "redirect:categories";
	}
	
	@RequestMapping(value = "categories/{categoryid}", method=RequestMethod.POST)
	public String showCategoryPlaylists(@RequestParam("categoryid") String categoryId, Model model, RedirectAttributes ra) {

		this.removeAllFromList(this.categoryPlaylists);

		String url = "https://api.spotify.com/v1/browse/categories/"+categoryId+"/playlists";
		HttpEntity<String> entity  = HttpRequestService.setEntityToAccessData(this.token);
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<PlaylistsSpotify> responseJson = null;
		ItemPlaylist[] playlists = null;
		
		do {
			try {
				responseJson = restTemplate.exchange(url, HttpMethod.GET, entity, PlaylistsSpotify.class);
				playlists = responseJson.getBody().getPlaylists().getItemsPlaylists();
				for(ItemPlaylist item : playlists) {
					this.categoryPlaylists.add(item);
				}
				url = responseJson.getBody().getPlaylists().getNext();
				
			} catch(RestClientException ex) {
				ra.addAttribute("error", ex.getMessage());
				ra.addFlashAttribute("error", ex.getMessage());
				return "redirect:categories/{categoryid}";
			}
		} while(url != null);

		model.addAttribute("playlists", this.categoryPlaylists);
		model.addAttribute("categoryId", categoryId.toUpperCase());
		
		return "categoryWithPlaylistsPage";
	}
	
	private void removeAllFromList(List<?> list) {
		if(list.size() != 0)
			list.removeAll(list);
	}
		
}
