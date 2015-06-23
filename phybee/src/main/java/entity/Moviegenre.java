package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the moviegenre database table.
 * 
 */
@Entity
@NamedQuery(name="Moviegenre.findAll", query="SELECT m FROM Moviegenre m")
public class Moviegenre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	//bi-directional many-to-one association to Genre
	@ManyToOne
	@JoinColumn(name="id_genres")
	private Genre genre;

	//bi-directional many-to-one association to Movie
	@ManyToOne
	@JoinColumn(name="id_moviex")
	private Movie movie;

	public Moviegenre() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Genre getGenre() {
		return this.genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public Movie getMovie() {
		return this.movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

}