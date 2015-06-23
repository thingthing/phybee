package dao;

import java.util.List;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import entity.Movie;

@Repository
public class MovieDaoImpl implements MovieDao
{
	private EntityManager em;

	@PersistenceContext
	void setEntityManager(EntityManager entityManager)
	{
		this.em = entityManager;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Movie> findAllMovie()
	{
		return this.em.createNamedQuery("Movie.findAll").getResultList();
	}

	@Override
	public void create(Movie entity)
	{
		this.em.persist(entity);
	}

	@Override
	public void remove(Movie entity)
	{
		this.em.remove(entity);
	}

	@Override
	public void update(Movie entity)
	{
		this.em.merge(entity);
	}

	@Override
	public Movie findMovieById(Integer id) throws NoResultException
	{
		return this.em.find(Movie.class, id);
	}

	@Override
	public List<Movie> findCurrentMovies()
	{
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<Movie> cq = cb.createQuery(Movie.class);
		Root<Movie> m = cq.from(Movie.class);
		cq.where(cb.and(
				cb.lessThanOrEqualTo(m.get("startRelease"), cb.currentDate()),
				cb.greaterThan(m.get("endRelease"), cb.currentDate())));
		return this.em.createQuery(cq).getResultList();
	}

	@Override
	public List<Movie> findCurrentMoviesAndSchedule()
	{
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<Movie> cq = cb.createQuery(Movie.class);
		Root<Movie> m = cq.from(Movie.class);
		cq.orderBy(cb.asc(m.get("schedules").get("scheduleDate")));
		cq.where(cb.and(
				cb.lessThanOrEqualTo(m.get("startRelease"), cb.currentDate()),
				cb.greaterThan(m.get("endRelease"), cb.currentDate()),
				cb.greaterThan(m.get("schedules").get("scheduleDate"),
						cb.currentDate())));
		return this.em.createQuery(cq).getResultList();
	}
	
	@Override
	public List<Movie> findNewMovies()
	{
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<Movie> cq = cb.createQuery(Movie.class);
		Root<Movie> m = cq.from(Movie.class);
		cq.where(cb.and(
				cb.lessThanOrEqualTo(m.get("startRelease"), cb.currentDate()),
				cb.greaterThan(m.get("schedules").get("scheduleDate"),
						cb.currentDate()),
				cb.greaterThan(m.get("endRelease"), cb.currentDate()),
				cb.lessThanOrEqualTo(cb.function("datediff", Integer.class,
						cb.currentDate(), m.get("startRelease")), cb.literal(7))));
		return this.em.createQuery(cq).getResultList();
	}

	@Override
	public List<Movie> findFuturMovies()
	{
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<Movie> cq = cb.createQuery(Movie.class);
		Root<Movie> m = cq.from(Movie.class);
		cq.where(cb.and(
				cb.greaterThan(m.get("startRelease"), cb.currentDate()),
				cb.lessThanOrEqualTo(
						cb.function("datediff", Integer.class,
								m.get("startRelease"), cb.currentDate()),
						cb.literal(7))));
		return this.em.createQuery(cq).getResultList();
	}

	@Override
	public List<Movie> findMoviesLike(String title)
	{
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<Movie> cq = cb.createQuery(Movie.class);
		Root<Movie> m = cq.from(Movie.class);
		cq.where(cb.like(m.get("title"), "%" + title + "%"));
		return this.em.createQuery(cq).getResultList();
	}
}
