package cegedim.fullstack.movie.data;

import java.util.List;

import lombok.Data;

@Data
public class MoviePage {
	
	private Integer page;
	
	private List<Object> results;

//	public Integer getPage() {
//		return page;
//	}
//
//	public void setPage(Integer page) {
//		this.page = page;
//	}
//	
//	public MoviePage() {
//	}
//
//	public MoviePage(Integer page, List<Object> movies) {
//		super();
//		this.page = page;
//		this.movies = movies;
//	}
//
//	@Override
//	public String toString() {
//		return "MoviePage [page=" + page + ", movies=" + movies + "]";
//	}
//
//	public List<Object> getMovies() {
//		return movies;
//	}
//
//	public void setMovies(List<Object> movies) {
//		this.movies = movies;
//	}

}
