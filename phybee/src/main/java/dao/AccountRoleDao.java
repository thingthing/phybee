package dao;

import java.util.List;

import entity.AccountRoles;

public interface AccountRoleDao
{
	List<AccountRoles> findAllAccountRoles();

//	Cours findCoursByCode(String code) throws NoResultException;
//
//	Cours findCoursByName(String name) throws NoResultException;

	void create(AccountRoles entity);

	void remove(AccountRoles entity);

	void update(AccountRoles entity);
}
