package dao;

import java.sql.Date;
import java.util.List;

import javax.persistence.NoResultException;

import entity.Schedule;

public interface ScheduleDao
{
	List<Schedule> findAllSchedule();

	Schedule findById(Integer id) throws NoResultException;

	List<Schedule> findSchedulesMovie(Integer movie_id);
	
	List<Schedule> findSchedulesMovie(Integer id, Date date);

	void create(Schedule entity);

	void remove(Schedule entity);

	void update(Schedule entity);
}
