package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import entity.Room;
@Repository
public class RoomDaoImpl implements RoomDao
{
	private EntityManager em;
	@PersistenceContext
	void setEntityManager(EntityManager entityManager)
	{
		this.em = entityManager;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Room> findAllRoom()
	{
		return this.em.createNamedQuery("Room.findAll").getResultList();
	}

	@Override
	public void create(Room entity)
	{
		this.em.persist(entity);
	}

	@Override
	public void remove(Room entity)
	{
		this.em.remove(entity);
	}

	@Override
	public void update(Room entity)
	{
		this.em.merge(entity);
	}

}
