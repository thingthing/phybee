package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the genre database table.
 * 
 */
@Entity
@NamedQuery(name="Genre.findAll", query="SELECT g FROM Genre g")
public class Genre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String name;

	//bi-directional many-to-one association to Moviegenre
	@OneToMany(mappedBy="genre")
	private List<Moviegenre> moviegenres;

	public Genre() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Moviegenre> getMoviegenres() {
		return this.moviegenres;
	}

	public void setMoviegenres(List<Moviegenre> moviegenres) {
		this.moviegenres = moviegenres;
	}

	public Moviegenre addMoviegenre(Moviegenre moviegenre) {
		getMoviegenres().add(moviegenre);
		moviegenre.setGenre(this);

		return moviegenre;
	}

	public Moviegenre removeMoviegenre(Moviegenre moviegenre) {
		getMoviegenres().remove(moviegenre);
		moviegenre.setGenre(null);

		return moviegenre;
	}

}