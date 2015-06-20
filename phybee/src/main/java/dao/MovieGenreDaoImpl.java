package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import entity.Moviegenre;
@Repository
public class MovieGenreDaoImpl implements MovieGenreDao
{
	private EntityManager em;
	@PersistenceContext
	void setEntityManager(EntityManager entityManager)
	{
		this.em = entityManager;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Moviegenre> findAllMovieGenre()
	{
		return this.em.createNamedQuery("Moviegenre.findAll").getResultList();
	}

	@Override
	public void create(Moviegenre entity)
	{
		this.em.persist(entity);
	}

	@Override
	public void remove(Moviegenre entity)
	{
		this.em.remove(entity);
	}

	@Override
	public void update(Moviegenre entity)
	{
		this.em.merge(entity);
	}

}
