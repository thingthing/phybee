package dao;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import entity.Schedule;
@Repository
public class ScheduleDaoImpl implements ScheduleDao
{
	private EntityManager em;
	@PersistenceContext
	void setEntityManager(EntityManager entityManager)
	{
		this.em = entityManager;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Schedule> findAllSchedule()
	{
		return this.em.createNamedQuery("Schedule.findAll").getResultList();
	}

	@Override
	public void create(Schedule entity)
	{
		this.em.persist(entity);
	}

	@Override
	public void remove(Schedule entity)
	{
		this.em.remove(entity);
	}

	@Override
	public void update(Schedule entity)
	{
		this.em.merge(entity);
	}

	@Override
	public Schedule findById(Integer id) throws NoResultException
	{
		return this.em.find(Schedule.class, id);
	}
	
	@Override
	public List<Schedule> findSchedulesMovie(Integer movie_id)
	{
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<Schedule> cq = cb.createQuery(Schedule.class);
		Root<Schedule> s = cq.from(Schedule.class);
		cq.where(cb.and(cb.equal(s.get("movie").get("id"), movie_id),
				cb.greaterThan(s.get("scheduleDate"), cb.currentDate())));
		return this.em.createQuery(cq).getResultList();
	}

	@Override
	public List<Schedule> findSchedulesMovie(Integer movie_id, Date date)
	{
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<Schedule> cq = cb.createQuery(Schedule.class);
		Root<Schedule> s = cq.from(Schedule.class);
		cq.where(cb.and(cb.equal(s.get("movie").get("id"), movie_id),
				cb.equal(s.get("scheduleDate"), date),
				cb.greaterThan(s.get("scheduleDate"), cb.currentDate())));
		return this.em.createQuery(cq).getResultList();
	}

}
