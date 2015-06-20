package dao;

import java.util.List;

import entity.Genre;

public interface GenreDao
{
	List<Genre> findAllGenre();

//	Cours findCoursByCode(String code) throws NoResultException;
//
//	Cours findCoursByName(String name) throws NoResultException;

	void create(Genre entity);

	void remove(Genre entity);

	void update(Genre entity);
}
