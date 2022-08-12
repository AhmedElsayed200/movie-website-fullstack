package cegedim.fullstack.movie.facades;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cegedim.fullstack.movie.data.MoviePage;
import cegedim.fullstack.movie.services.MovieService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MovieFacade {
	
	@Autowired
	MovieService movieService;
	
	public Object getPopularMovies(Integer page) {
		return movieService.getPopularMovies(page);
	}
	
	public Object searchMovies(String keyword) {
		return movieService.searchMovies(keyword);
	}
	
	public Object getMovieDetails(Long movieID) {
		return movieService.getMovieDetails(movieID);
	}
}
