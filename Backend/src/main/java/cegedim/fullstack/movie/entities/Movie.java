package cegedim.fullstack.movie.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
@Data
public class Movie {
	
	@Id
	private Long id;
	
	private String title;
	private int vote_average;
	private int vote_count;
	private String poster_path;

	@Lob // this will be transformed to the type text (more than 255 char)
	private String overview;
	private String release_date;
}