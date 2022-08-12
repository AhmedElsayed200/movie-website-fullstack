package cegedim.fullstack.movie.services;

import cegedim.fullstack.movie.entities.Movie;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import cegedim.fullstack.movie.data.MoviePage;
import cegedim.fullstack.movie.repositories.MovieRepo;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MovieService {

	private final MovieRepo movieRepo;

	private final RestTemplate restTemplate = new RestTemplate();
	
	private final String apiKey = "a97243d7813d31446f6c43284e6854d5";

	private final String apiUrl = "https://api.themoviedb.org/3";
	
	private static final String URL_SEGEMENT_FOR_POPULAR = "/movie/popular";
	
	private static final String URL_SEGEMENT_FOR_SEARCH = "/search/movie";
	
	public MoviePage getPopularMovies(Integer page) {
		String urlForPopularMovies = apiUrl + URL_SEGEMENT_FOR_POPULAR + "?api_key=" + apiKey + "&page="
				+ page;
		System.out.println(urlForPopularMovies);
		return restTemplate.getForEntity(urlForPopularMovies, MoviePage.class).getBody();
	}
	
	public MoviePage searchMovies(String keyword) {
		String urlForSearchMovies = apiUrl + URL_SEGEMENT_FOR_SEARCH + "?api_key=" + apiKey + "&query="
				+ keyword;
		System.out.println(urlForSearchMovies);
		return restTemplate.getForEntity(urlForSearchMovies, MoviePage.class).getBody();
	}

	public Movie getMovieDetails(Long movieID) {
		String urlForMovieDetails = apiUrl + "/movie/" + movieID + "?api_key=" + apiKey + "&language=en-US";
		System.out.println(urlForMovieDetails);
		if(movieRepo.existsById(movieID)) {
			System.out.println("exists in h2 db");
			return movieRepo.findById(movieID).get();
		} else {
			Movie movie = restTemplate.getForEntity(urlForMovieDetails, Movie.class).getBody();
			movieRepo.save(movie);
			System.out.println("added to h2 db");
			return movie;
		}
	}
}
