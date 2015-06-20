package dao;

import java.util.List;

import entity.Producer;

public interface ProducerDao
{
	List<Producer> findAllProducer();

//	Cours findCoursByCode(String code) throws NoResultException;
//
//	Cours findCoursByName(String name) throws NoResultException;

	void create(Producer entity);

	void remove(Producer entity);

	void update(Producer entity);
}
