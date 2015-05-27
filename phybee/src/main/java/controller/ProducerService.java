package controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import db.PhybeeDb;
import bean.ProducerBean;

public class ProducerService
{
	public ProducerService()
	{
		
	}
	
	public static ProducerBean getProducer(Integer prod_id)
	{
		ProducerBean prod = new ProducerBean();
		
		try
		{
			PhybeeDb db = new PhybeeDb();
			ResultSet resultSet = db.executeQuery("select * from producer where id="+prod_id);
			
			if (resultSet.next())
			{
				prod.setId(resultSet.getInt("id"));
				prod.setName(resultSet.getString("name"));
			}

			db.closeConnection();

		} catch (NamingException e)
		{
			e.printStackTrace();
		} catch (SQLException sqlException)
		{
			sqlException.printStackTrace();
		}
		return prod;
	}
}
