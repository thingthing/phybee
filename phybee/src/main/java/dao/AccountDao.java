package dao;

import java.util.List;

import javax.persistence.NoResultException;

import entity.Account;

public interface AccountDao
{
	List<Account> findAllAccount();

	Account findAcccountByMail(String email) throws NoResultException;
	
	Account findAcccountById(Integer id) throws NoResultException;
	
	void create(Account entity);

	void remove(Account entity);

	void update(Account entity);
}
