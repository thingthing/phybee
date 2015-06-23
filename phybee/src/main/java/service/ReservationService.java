package service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bean.DateScheduleBean;
import dao.AccountDao;
import dao.MovieDao;
import dao.ReservationDao;
import dao.ScheduleDao;
import dao.TicketDao;
import entity.Account;
import entity.Reservation;
import entity.Schedule;
import entity.Ticket;
@Transactional
@Service
public class ReservationService
{
	@Autowired
	private ScheduleDao scheduleDao;
	@Autowired
	private TicketDao ticketDao;
	@Autowired
	private MovieDao movieDao;
	@Autowired
	private ReservationDao reservationDao;
	@Autowired
	private AccountDao accountDao;
	
	public ReservationService()
	{

	}

	public void removeAvailableSeat(Integer id_schedule, Integer seats_taken,
			Boolean is_priority)
	{
		try
		{
			Schedule schedule = scheduleDao.findById(id_schedule);
			if (is_priority)
			{
				schedule.setPrioritySeatRemain(schedule.getPrioritySeatRemain() - seats_taken);
			} else
			{
				schedule.setSeatRemain(schedule.getSeatRemain() - seats_taken);
			}
			scheduleDao.update(schedule);
		} catch (NoResultException e)
		{
			System.out.println("No schedule found");
			e.printStackTrace();
		}
	}

	private List<DateScheduleBean> createDateScheduleBeanFromSchedules(List<Schedule> schedule)
	{
		ArrayList<DateScheduleBean> dateSchedules = new ArrayList<DateScheduleBean>();
		DateScheduleBean dateschedule = null;
		for (Schedule s : schedule)
		{
			Date date_tmp = s.getScheduleDate();
			if (dateschedule == null
					|| date_tmp.equals(dateschedule.getDate()) == false)
			{
				if (dateschedule != null)
					dateSchedules.add(dateschedule);
				dateschedule = new DateScheduleBean(date_tmp,
						new ArrayList<Schedule>());
			}
			dateschedule.addSchedule(s);
		}
		if (dateschedule != null)
			dateSchedules.add(dateschedule);
		return dateSchedules;
	}
	
	public List<Ticket> getTicketInfo()
	{
		return ticketDao.findAllTicket();
	}

	public Schedule getScheduleInfo(Integer id_schedule) throws NoResultException
	{
		return (this.scheduleDao.findById(id_schedule));
	}

	public List<DateScheduleBean> getScheduleInfo(Integer filmId, Date date)
	{
		return (this.createDateScheduleBeanFromSchedules(this.scheduleDao.findSchedulesMovie(filmId, date)));
	}

	public List<DateScheduleBean> getScheduleInfoWithFilmId(Integer filmId) throws NoResultException
	{
		return (this.createDateScheduleBeanFromSchedules(this.scheduleDao.findSchedulesMovie(filmId)));
	}

	public void setReservationInfo(Integer adult, Integer child,
			Integer disabled, Integer schedule_id, Integer user_id)
	{
		try
		{
			Account account = accountDao.findAcccountById(user_id);
			Schedule schedule = scheduleDao.findById(schedule_id);
			
			Reservation reservation = new Reservation();
			reservation.setAccount(account);
			reservation.setAdult(adult);
			reservation.setChild(child);
			reservation.setDisabled(disabled);
			reservation.setSchedule(schedule);
			
			reservationDao.create(reservation);
		} catch (NoResultException e)
		{
			System.out.println("No schedule/account found");
			e.printStackTrace();
		}
	}
}
