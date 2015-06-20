package service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import validator.EmailExistsException;
import bean.PasswordBean;
import bean.UserBean;
import bean.UserDTOBean;
import bean.UserMovies;
import dao.AccountDao;
import dao.AccountRoleDao;
import dao.MovieDao;
import entity.Account;
import entity.AccountPK;
import entity.AccountRoles;

@Transactional
@Service
public class UserService
{
	@Autowired
	private AccountDao accountDao;

	@Autowired
	private AccountRoleDao roleDao;

	@Autowired
	private MovieDao movieDao;
	
	public UserService()
	{

	}

	public UserBean login(UserBean user) throws Exception
	{
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String name = auth.getName();

		System.out.println("Try to login with name = " + name);
		if (!name.equals("anonymousUser"))
		{
			UserBean userBean = this.login(name);

			user.setEmail(userBean.getEmail());
			user.setId(userBean.getId());
			user.setFirstName(userBean.getFirstName());
			user.setLastName(userBean.getLastName());
			user.setPassword(userBean.getPassword());
			// for testing purpose:
			System.out.println("username: " + user.getFirstName());
			System.out.println("username: " + user.getLastName());
			System.out.println("password: " + user.getPassword());
			System.out.println("email: " + user.getEmail());

			System.out.println("Id: " + user.getId());
			return (userBean);
		}
		throw new Exception("User not log in");
	}

	public UserBean login(String login) throws Exception
	{
		UserBean user = new UserBean();
		try
		{
			Account account = accountDao.findAcccountByMail(login);
			System.out.println("User found");
			user.setUserFromEntity(account);
		} catch (NoResultException e)
		{
			System.out.println(e);
			throw e;
		} catch (Exception e)
		{
			System.out.println("Other exception");
			System.out.println(e);
		}
		
		return (user);
	}

	private String getHashPassword(String password)
	{
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder.encode(password);
	}

	public UserBean subscribe(UserDTOBean accountDto)
			throws EmailExistsException
	{
		System.out.println("Trying to subscribe " + accountDto.getEmail());
		if (this.emailExist(accountDto.getEmail()))
		{
			throw new EmailExistsException(
					"There is an account with that email adress: "
							+ accountDto.getEmail());
		}
		System.out.println("New account");
		AccountPK id = new AccountPK();
		id.setEmail(accountDto.getEmail());
		
		Account account = new Account();
		System.out.println("Setting data");
		account.setFirstname(accountDto.getFirstName());
		account.setLastname(accountDto.getLastName());
		account.setId(id);
		account.setPassword(this.getHashPassword(accountDto.getPassword()));
		account.setAccountRole(new ArrayList<AccountRoles>());
		
		AccountRoles role = new AccountRoles();
		role.setRole("ROLE_USER");
		System.out.println("Adding account role");
		account.addAccountRole(role);
		
		roleDao.create(role);
		accountDao.create(account);
		
		UserBean user = new UserBean();
		user.setUserFromEntity(account);
		return (user);
	}

	public boolean setUserPassword(UserBean currentUser,
			PasswordBean password)
	{
		try
		{
			Account account = accountDao.findAcccountById(currentUser.getId());
			String hashedPassword = this.getHashPassword(password
					.getPassword());
			account.setPassword(hashedPassword);
			accountDao.update(account);
		} catch (NoResultException e)
		{
			System.out.println("User not found in set user password: " + currentUser.getId());
			e.printStackTrace();
			return (false);
		}
		currentUser.setPassword(password.getPassword());
		return (true);
	}

	public ArrayList<UserMovies> getUserMovies(Integer user_id)
	{
		return (movieDao.getUserMovies(user_id));
	}

	private boolean emailExist(final String email)
	{
		try
		{
			accountDao.findAcccountByMail(email);
			System.out.println("Exit find by account");
		} catch (NoResultException e)
		{
			return false;
		} catch (Exception sqlException)
		{
			sqlException.printStackTrace();
		}
		return (true);
	}
}
