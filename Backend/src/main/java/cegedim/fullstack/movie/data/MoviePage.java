package cegedim.fullstack.movie.data;

import java.util.List;

import lombok.Data;

@Data
public class MoviePage {
	
	private Integer page;
	
	private List<MovieInfo> results;

}
