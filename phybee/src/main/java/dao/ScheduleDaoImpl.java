package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

}
