package service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;

import bean.UserDTOBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import db.PhybeeDb;
import bean.UserBean;
import validator.EmailExistsException;

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

	public static UserBean subscribe(UserDTOBean accountDto) throws EmailExistsException
	{
		if (emailExist(accountDto.getEmail())) {
			throw new EmailExistsException("There is an account with that email adress: " + accountDto.getEmail());
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
			PreparedStatement preparedStatement = db.prepareQuery("insert into account (firstname, lastname, email, password) values (?,?,?,?)");

			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String hashedPassword = passwordEncoder.encode(accountDto.getPassword());
			
			preparedStatement.setString(1, accountDto.getFirstName());
			preparedStatement.setString(2, accountDto.getLastName());
			preparedStatement.setString(3, accountDto.getEmail());
			preparedStatement.setString(4, hashedPassword);
			preparedStatement.executeUpdate();
			
			ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
			if (generatedKeys.next()) {
				Integer id = generatedKeys.getInt(1);
				System.out.println("User id == " + id);
                user.setId(id);
            }
			
			preparedStatement = db.prepareQuery("insert into account_roles (email, ROLE) values (?,?)");
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

	private static boolean emailExist(final String email) {
		String sql = "select * from account where email = ?";
		try {
			PhybeeDb db = new PhybeeDb();
			PreparedStatement preparedStatement = db.prepareQuery(sql);
			preparedStatement.setString(1, email);
			System.out.println(preparedStatement);
			ResultSet resultset = preparedStatement.executeQuery();
			if (!resultset.next()) {
				db.closeConnection();
				return false;
			}
			db.closeConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
		return (true);
	}
}
