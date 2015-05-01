package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class PhybeeDb
{
	private Connection connection;
	
	public PhybeeDb()
	{
		InitialContext initialContext;
		try
		{
			initialContext = new InitialContext();
			Context envContext = (Context) initialContext
					.lookup("java:comp/env");
			DataSource dataSource = (DataSource) envContext
					.lookup("jdbc/phybeedb");
			
			this.connection = dataSource.getConnection();
			
		} catch (NamingException e)
		{
			e.printStackTrace();
		}  catch (SQLException sqlException)
		{
			sqlException.printStackTrace();
		}
	}
	
	public ResultSet executeQuery(String query) throws SQLException
	{
		PreparedStatement preparedStatement = this.connection
				.prepareStatement(query);
		return preparedStatement.executeQuery();
	}
	
	public void closeConnection() throws SQLException
	{
		this.connection.close();
	}
}
