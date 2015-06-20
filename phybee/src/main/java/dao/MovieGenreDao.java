package dao;

import java.util.List;

import entity.Moviegenre;

public interface MovieGenreDao
{
	List<Moviegenre> findAllMovieGenre();

//	Cours findCoursByCode(String code) throws NoResultException;
//
//	Cours findCoursByName(String name) throws NoResultException;

	void create(Moviegenre entity);

	void remove(Moviegenre entity);

	void update(Moviegenre entity);
}
