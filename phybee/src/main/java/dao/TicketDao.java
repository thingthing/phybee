package dao;

import java.util.List;

import entity.Ticket;

public interface TicketDao
{
	List<Ticket> findAllTicket();

//	Cours findCoursByCode(String code) throws NoResultException;
//
//	Cours findCoursByName(String name) throws NoResultException;

	void create(Ticket entity);

	void remove(Ticket entity);

	void update(Ticket entity);
}
