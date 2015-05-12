package db;

import java.sql.Statement;
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

	public PhybeeDb() throws NamingException, SQLException
	{
		InitialContext initialContext;
		initialContext = new InitialContext();
		Context envContext = (Context) initialContext.lookup("java:comp/env");
		DataSource dataSource = (DataSource) envContext.lookup("jdbc/theater");

		this.connection = dataSource.getConnection();

	}

	public ResultSet executeQuery(String query) throws SQLException
	{
		System.out.println(query);
		PreparedStatement preparedStatement = this.prepareQuery(query);
		return preparedStatement.executeQuery();
	}

	public PreparedStatement prepareQuery(String query) throws SQLException
	{
		return (this.connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS));
	}
	
	public void closeConnection() throws SQLException
	{
		this.connection.close();
	}
}
