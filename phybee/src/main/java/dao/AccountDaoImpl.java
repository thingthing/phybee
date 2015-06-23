package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import entity.Account;

@Repository
public class AccountDaoImpl implements AccountDao
{
	private EntityManager em;

	@PersistenceContext
	void setEntityManager(EntityManager entityManager)
	{
		this.em = entityManager;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Account> findAllAccount()
	{
		return this.em.createNamedQuery("Account.findAll").getResultList();
	}

	@Override
	public void create(Account entity)
	{
		this.em.persist(entity);
	}

	@Override
	public void remove(Account entity)
	{
		this.em.remove(entity);
	}

	@Override
	public void update(Account entity)
	{
		this.em.merge(entity);
	}

	@Override
	public Account findAcccountByMail(String email) throws NoResultException
	{
		Query query = this.em.createNamedQuery("Account.findByMail");
		query.setParameter("mail", email);
		Account result = (Account) query.getSingleResult();
		return result;
	}

	@Override
	public Account findAcccountById(Integer id) throws NoResultException
	{
		return (Account) this.em.createNamedQuery("Account.findById")
				.setParameter("id", id).getSingleResult();
	}

}
