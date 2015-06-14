package service;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

import javax.naming.NamingException;

import bean.*;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import db.PhybeeDb;
import validator.EmailExistsException;

public class UserService
{

	public UserService()
	{

	}

	public static UserBean login(UserBean user) throws Exception
	{
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String name = auth.getName();

		System.out.println("Try to login with name = " + name);
		if (!name.equals("anonymousUser"))
		{
			UserBean userBean = UserService.login(name);

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

	public static UserBean login(String login) throws Exception
	{
		String sql = "select * from account where email = ?";
		UserBean user = new UserBean();

		try
		{
			PhybeeDb db = new PhybeeDb();
			PreparedStatement preparedStatement = db.prepareQuery(sql);
			preparedStatement.setString(1, login);
			System.out.println(preparedStatement);
			ResultSet resultset = preparedStatement.executeQuery();
			if (!resultset.next())
			{
				throw new Exception("User not found");
			} else
			{
				user.setFirstName(resultset.getString("firstname"));
				user.setLastName(resultset.getString("lastname"));
				user.setEmail(resultset.getString("email"));
				user.setPassword(resultset.getString("password"));
				user.setId(resultset.getInt("id"));
			}
			db.closeConnection();
		} catch (NamingException e)
		{
			e.printStackTrace();
		} catch (SQLException sqlException)
		{
			sqlException.printStackTrace();
		}
		return (user);
	}

	private static String getHashPassword(String password)
	{
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder.encode(password);
	}
	
	public static UserBean subscribe(UserDTOBean accountDto)
			throws EmailExistsException
	{
		if (emailExist(accountDto.getEmail()))
		{
			throw new EmailExistsException(
					"There is an account with that email adress: "
							+ accountDto.getEmail());
		}
		UserBean user = new UserBean();
		user.setFirstName(accountDto.getFirstName());
		user.setLastName(accountDto.getLastName());
		user.setEmail(accountDto.getEmail());
		user.setPassword(accountDto.getPassword());
		user.setId(-1);

		try
		{
			PhybeeDb db = new PhybeeDb();
			PreparedStatement preparedStatement = db
					.prepareQuery("insert into account (firstname, lastname, email, password) values (?,?,?,?)");

			String hashedPassword = UserService.getHashPassword(accountDto.getPassword());
			preparedStatement.setString(1, accountDto.getFirstName());
			preparedStatement.setString(2, accountDto.getLastName());
			preparedStatement.setString(3, accountDto.getEmail());
			preparedStatement.setString(4, hashedPassword);
			preparedStatement.executeUpdate();

			ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
			if (generatedKeys.next())
			{
				Integer id = generatedKeys.getInt(1);
				System.out.println("User id == " + id);
				user.setId(id);
			}

			preparedStatement = db
					.prepareQuery("insert into account_roles (email, ROLE) values (?,?)");
			preparedStatement.setString(1, accountDto.getEmail());
			preparedStatement.setString(2, "ROLE_USER");
			preparedStatement.executeUpdate();

			db.closeConnection();

		} catch (NamingException e)
		{
			e.printStackTrace();
		} catch (SQLException sqlException)
		{
			sqlException.printStackTrace();
		}
		return (user);
	}

	public static boolean setUserPassword(UserBean currentUser, PasswordBean password)
	{
		try
		{
			PhybeeDb db = new PhybeeDb();
			PreparedStatement preparedStatement = db
					.prepareQuery("update account set password=? where id=?");

			String hashedPassword = UserService.getHashPassword(password.getPassword());
			preparedStatement.setString(1, hashedPassword);
			preparedStatement.setInt(2, currentUser.getId());
			preparedStatement.executeUpdate();

			db.closeConnection();

		} catch (NamingException e)
		{
			e.printStackTrace();
			return (false);
		} catch (SQLException sqlException)
		{
			sqlException.printStackTrace();
			return (false);
		}
		currentUser.setPassword(password.getPassword());
		return (true);
	}
	
	public static ArrayList<UserMovies> getUserMovies(Integer user_id)
	{
		String sql = "select r.*, s.*, m.* from reservation as r, schedule as s, movie as m where r.id_user = ? and r.id_schedule = s.id and s.id_movie = m.id";
		ArrayList<UserMovies> movieList = new ArrayList<UserMovies>();

		try
		{
			PhybeeDb db = new PhybeeDb();
			PreparedStatement preparedStatement = db.prepareQuery(sql);
			preparedStatement.setInt(1, user_id);
			System.out.println(preparedStatement);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next())
			{
				MovieBean movie = new MovieBean(resultSet.getInt("m.id"),
						resultSet.getInt("m.id_producer"),
						resultSet.getString("m.title"),
						resultSet.getString("m.synopsis"),
						resultSet.getTime("m.time"),
						resultSet.getString("m.poster"),
						resultSet.getDate("m.release"),
						resultSet.getDate("m.end_release"),
						GenreService.getGenreOfMovie(resultSet.getInt("m.id")));
				
				movieList.add(new UserMovies(movie, resultSet.getInt("r.adult"),
						resultSet.getInt("r.child"),
						resultSet.getInt("r.disabled"),
						resultSet.getDate("s.date"),
						resultSet.getTime("s.start"),
						resultSet.getTime("s.end")));
			}
			db.closeConnection();
		} catch (NamingException e)
		{
			e.printStackTrace();
		} catch (SQLException sqlException)
		{
			sqlException.printStackTrace();
		}
		return (movieList);
	}

	private static boolean emailExist(final String email)
	{
		String sql = "select * from account where email = ?";
		try
		{
			PhybeeDb db = new PhybeeDb();
			PreparedStatement preparedStatement = db.prepareQuery(sql);
			preparedStatement.setString(1, email);
			System.out.println(preparedStatement);
			ResultSet resultset = preparedStatement.executeQuery();
			if (!resultset.next())
			{
				db.closeConnection();
				return false;
			}
			db.closeConnection();
		} catch (NamingException e)
		{
			e.printStackTrace();
		} catch (SQLException sqlException)
		{
			sqlException.printStackTrace();
		}
		return (true);
	}
}
