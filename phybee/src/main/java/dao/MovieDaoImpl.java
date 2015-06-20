package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import bean.UserMovies;
import entity.Movie;
import entity.Reservation;
import entity.Schedule;

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
	public ArrayList<UserMovies> getUserMovies(Integer user_id)
	{
		ArrayList<UserMovies> movieList = new ArrayList<UserMovies>();

		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);

		Root<Reservation> r = cq.from(Reservation.class);
		Root<Schedule> s = cq.from(Schedule.class);
		Root<Movie> m = cq.from(Movie.class);

		cq.multiselect(r, s, m);
		cq.where(cb.and(cb.equal(r.get("id_user"), user_id),
				cb.equal(r.get("id_schedule"), s.get("id")), cb.equal(s.get("id_movie"), m.get("id"))));
		
		List<Object[]> resultSet = em.createQuery(cq).getResultList();
		for (Object[] values : resultSet)
		{
			for (Object value: values)
			{
				System.out.println("Object == " + value);
			}
		}
//		while (resultSet.next())
//		{
//			MovieBean movie = new MovieBean(resultSet.getInt("m.id"),
//					resultSet.getInt("m.id_producer"),
//					resultSet.getString("m.title"),
//					resultSet.getString("m.synopsis"),
//					resultSet.getString("m.trailer"),
//					resultSet.getTime("m.time"),
//					resultSet.getString("m.poster"),
//					resultSet.getDate("m.release"),
//					resultSet.getDate("m.end_release"),
//					GenreService.getGenreOfMovie(resultSet.getInt("m.id")));
//
//			movieList.add(new UserMovies(movie, resultSet.getInt("r.adult"),
//					resultSet.getInt("r.child"),
//					resultSet.getInt("r.disabled"),
//					resultSet.getDate("s.date"), resultSet.getTime("s.start"),
//					resultSet.getTime("s.end")));
//		}
		return (movieList);
	}

}
