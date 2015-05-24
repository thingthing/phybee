package service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import db.PhybeeDb;
import bean.UserBean;

public class UserService
{
	public UserService()
	{

	}

	public static UserBean login(String login)
			throws Exception
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
				user = new UserBean(resultset.getString("firstname"),
						resultset.getString("lastname"),
						resultset.getString("email"),
						resultset.getString("password"), resultset.getInt("id"));
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

	public static UserBean subscribe(String firstName, String lastName,
			String email, String password)
	{
		UserBean user = new UserBean(firstName, lastName, email, password, -1);

		try
		{
			PhybeeDb db = new PhybeeDb();
			PreparedStatement preparedStatement = db.prepareQuery("insert into account (firstname, lastname, email, password) values (?,?,?,?)");

			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String hashedPassword = passwordEncoder.encode(password);
			
			preparedStatement.setString(1, firstName);
			preparedStatement.setString(2, lastName);
			preparedStatement.setString(3, email);
			preparedStatement.setString(4, hashedPassword);
			preparedStatement.executeUpdate();
			
			ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
			if (generatedKeys.next()) {
				Integer id = generatedKeys.getInt(1);
				System.out.println("User id == " + id);
                user.setId(id);
            }
			
			preparedStatement = db.prepareQuery("insert into account_roles (email, ROLE) values (?,?)");
			preparedStatement.setString(1, email);
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
}
