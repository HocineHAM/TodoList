package com.hocine.listeTodos.service;

import java.util.List;

public interface ICrudService <T, ID> {

	List<T> getAll();
	
	T findbyid(ID id);
	
	T add(T entity);
	
	T update(T entity);
	
	void delete(T entity);
	
	void saveAll(Iterable<T> iterable);

}
