package dao;

import java.util.List;

import entity.Schedule;

public interface ScheduleDao
{
	List<Schedule> findAllSchedule();

//	Cours findCoursByCode(String code) throws NoResultException;
//
//	Cours findCoursByName(String name) throws NoResultException;

	void create(Schedule entity);

	void remove(Schedule entity);

	void update(Schedule entity);
}
