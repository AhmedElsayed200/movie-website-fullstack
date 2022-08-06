package cegedim.fullstack.movie.facades;

import org.springframework.stereotype.Service;

import cegedim.fullstack.movie.services.MovieService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MovieFacade {
	
	public final MovieService moveService = new MovieService();
	
	public Object getPopularMovies(Integer page) {
		return moveService.getPopularMovies(page);
	}
}
