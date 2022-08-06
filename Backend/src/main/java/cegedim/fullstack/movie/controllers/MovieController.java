package cegedim.fullstack.movie.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cegedim.fullstack.movie.facades.MovieFacade;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v1/movies")
public class MovieController {
	
	private final MovieFacade movieFacade = new MovieFacade();
	
	@CrossOrigin(origins = "*")
	@GetMapping(path = "/popular", produces = { 
			MediaType.APPLICATION_JSON_VALUE, 
			MediaType.APPLICATION_XML_VALUE 
			}) // http://localhost:8080/api/v1/movies/popular?page={page}
	public ResponseEntity<Object> getPopularMovies(@RequestParam(value = "page", defaultValue = "1") int page){
		System.out.println("helloooooo");
		return new ResponseEntity<>(movieFacade.getPopularMovies(page), HttpStatus.OK);
	}
}
