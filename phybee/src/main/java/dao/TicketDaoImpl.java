package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import entity.Ticket;
@Repository
public class TicketDaoImpl implements TicketDao
{
	private EntityManager em;
	@PersistenceContext
	void setEntityManager(EntityManager entityManager)
	{
		this.em = entityManager;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Ticket> findAllTicket()
	{
		return this.em.createNamedQuery("Ticket.findAll").getResultList();
	}

	@Override
	public void create(Ticket entity)
	{
		this.em.persist(entity);
	}

	@Override
	public void remove(Ticket entity)
	{
		this.em.remove(entity);
	}

	@Override
	public void update(Ticket entity)
	{
		this.em.merge(entity);
	}

}
