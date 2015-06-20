package dao;

import java.util.List;

import entity.Reservation;

public interface ReservationDao
{
	List<Reservation> findAllReservation();

//	Cours findCoursByCode(String code) throws NoResultException;
//
//	Cours findCoursByName(String name) throws NoResultException;

	void create(Reservation entity);

	void remove(Reservation entity);

	void update(Reservation entity);
}
