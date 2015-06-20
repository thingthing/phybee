package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import entity.Genre;
@Repository
public class GenreDaoImpl implements GenreDao
{
	private EntityManager em;
	@PersistenceContext
	void setEntityManager(EntityManager entityManager)
	{
		this.em = entityManager;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Genre> findAllGenre()
	{
		return this.em.createNamedQuery("Genre.findAll").getResultList();
	}

	@Override
	public void create(Genre entity)
	{
		this.em.persist(entity);
	}

	@Override
	public void remove(Genre entity)
	{
		this.em.remove(entity);
	}

	@Override
	public void update(Genre entity)
	{
		this.em.merge(entity);
	}

}
