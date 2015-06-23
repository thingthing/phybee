package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import entity.AccountRoles;
@Repository
public class AccountRoleDaoImpl implements AccountRoleDao
{
	private EntityManager em;
	@PersistenceContext
	void setEntityManager(EntityManager entityManager)
	{
		this.em = entityManager;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<AccountRoles> findAllAccountRoles()
	{
		return this.em.createNamedQuery("AccountRoles.findAll").getResultList();
	}

	@Override
	public void create(AccountRoles entity)
	{
		this.em.persist(entity);
	}

	@Override
	public void remove(AccountRoles entity)
	{
		this.em.remove(entity);
	}

	@Override
	public void update(AccountRoles entity)
	{
		this.em.merge(entity);
	}

}
