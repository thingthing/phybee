package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import entity.Reservation;
@Repository
public class ReservationDaoImpl implements ReservationDao
{
	private EntityManager em;
	@PersistenceContext
	void setEntityManager(EntityManager entityManager)
	{
		this.em = entityManager;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Reservation> findAllReservation()
	{
		return this.em.createNamedQuery("Reservation.findAll").getResultList();
	}

	@Override
	public void create(Reservation entity)
	{
		this.em.persist(entity);
	}

	@Override
	public void remove(Reservation entity)
	{
		this.em.remove(entity);
	}

	@Override
	public void update(Reservation entity)
	{
		this.em.merge(entity);
	}

	@Override
	public List<Reservation> getUserReservation(Integer user_id)
	{

		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<Reservation> cq = cb.createQuery(Reservation.class);
		Root<Reservation> r = cq.from(Reservation.class);
		cq.where(cb.equal(r.get("account").get("id").get("id"), user_id));

		return this.em.createQuery(cq).getResultList();
	}
}
