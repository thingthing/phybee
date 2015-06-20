package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import entity.Producer;
@Repository
public class ProducerDaoImpl implements ProducerDao
{
	private EntityManager em;
	@PersistenceContext
	void setEntityManager(EntityManager entityManager)
	{
		this.em = entityManager;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Producer> findAllProducer()
	{
		return this.em.createNamedQuery("Producer.findAll").getResultList();
	}

	@Override
	public void create(Producer entity)
	{
		this.em.persist(entity);
	}

	@Override
	public void remove(Producer entity)
	{
		this.em.remove(entity);
	}

	@Override
	public void update(Producer entity)
	{
		this.em.merge(entity);
	}

}
