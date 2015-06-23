package dao;

import java.util.List;

import entity.Reservation;

public interface ReservationDao
{
	List<Reservation> findAllReservation();

	List<Reservation> getUserReservation(Integer user_id);

	void create(Reservation entity);

	void remove(Reservation entity);

	void update(Reservation entity);
}
