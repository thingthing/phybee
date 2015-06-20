package dao;

import java.util.List;

import entity.Room;

public interface RoomDao
{
	List<Room> findAllRoom();

//	Cours findCoursByCode(String code) throws NoResultException;
//
//	Cours findCoursByName(String name) throws NoResultException;

	void create(Room entity);

	void remove(Room entity);

	void update(Room entity);
}
