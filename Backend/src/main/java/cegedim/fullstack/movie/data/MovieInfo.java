package cegedim.fullstack.movie.data;

import lombok.Data;

@Data
public class MovieInfo {
	private Integer id;
    private String title;
    private String poster_path;
}
