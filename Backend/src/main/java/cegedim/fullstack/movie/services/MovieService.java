package cegedim.fullstack.movie.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import cegedim.fullstack.movie.data.MoviePage;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MovieService {

	private final RestTemplate restTemplate = new RestTemplate();
	
	private String apiKey = "a97243d7813d31446f6c43284e6854d5";

	private String apiUrl = "https://api.themoviedb.org/3";
	
	private static final String URL_SEGEMENT_FOR_POPULAR = "/movie/popular";
	
	private static final String URL_SEGEMENT_FOR_SEARCH = "/search/movie";
	
	public String getPopularMovies(Integer page) {
		String urlForPopularMovies = apiUrl + URL_SEGEMENT_FOR_POPULAR + "?api_key=" + apiKey + "&page="
				+ page.intValue();
		System.out.println(urlForPopularMovies);
		return restTemplate.getForEntity(urlForPopularMovies, String.class).getBody(); // edit this later [String.class]
	}
	
	public String searchMovies(String keyword) {
		String urlForSearchMovies = apiUrl + URL_SEGEMENT_FOR_SEARCH + "?api_key=" + apiKey + "&query="
				+ keyword;
		System.out.println(urlForSearchMovies);
		return restTemplate.getForEntity(urlForSearchMovies, String.class).getBody(); // edit this later [String.class]
	}
}
