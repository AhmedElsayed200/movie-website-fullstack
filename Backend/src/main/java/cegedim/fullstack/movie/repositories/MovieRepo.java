package cegedim.fullstack.movie.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cegedim.fullstack.movie.entities.Movie;

@Repository
public interface MovieRepo extends CrudRepository<Movie, Long> {
	
}
