package service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateService
{
	public DateService()
	{
		
	}
	
	static public Date parseDate(String date, String format) throws ParseException
	{
		SimpleDateFormat formatDate = new SimpleDateFormat(format);
        java.util.Date parsed = formatDate.parse(date);
        return (new java.sql.Date(parsed.getTime()));
	}
	
	static public Date parseDate(String date) throws ParseException
	{
		return (DateService.parseDate(date, "MM/dd/yyyy"));
	}
}
