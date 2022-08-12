package cegedim.fullstack.movie.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cegedim.fullstack.movie.facades.MovieFacade;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v1/movies")
public class MovieController {
	
	@Autowired
	MovieFacade movieFacade;
	
	@CrossOrigin(origins = "*")
	@GetMapping(path = "/popular", produces = { 
			MediaType.APPLICATION_JSON_VALUE, 
			MediaType.APPLICATION_XML_VALUE 
			}) // http://localhost:8080/api/v1/movies/popular?page={page}
	public ResponseEntity<Object> getPopularMovies(@RequestParam(value = "page", defaultValue = "1") Integer page){
		System.out.println("getPopularMovies called");
		return new ResponseEntity<>(movieFacade.getPopularMovies(page), HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping(path = "/search", produces = { 
			MediaType.APPLICATION_JSON_VALUE, 
			MediaType.APPLICATION_XML_VALUE 
			}) // http://localhost:8080/api/v1/movies/search?query={keyword}
	public ResponseEntity<Object> searchMovies(@RequestParam(value = "query", defaultValue = "1") String keyword){
		System.out.println("searchMovies called");
		return new ResponseEntity<>(movieFacade.searchMovies(keyword), HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping(path = "/{movieID}", produces = { 
			MediaType.APPLICATION_JSON_VALUE, 
			MediaType.APPLICATION_XML_VALUE 
			}) // http://localhost:8080/api/v1/movies/{movieID}
	public ResponseEntity<Object> getMovieDetails(@PathVariable Long movieID){
		System.out.println("getMovieDetails called");
		return new ResponseEntity<>(movieFacade.getMovieDetails(movieID), HttpStatus.OK);
	}
}
