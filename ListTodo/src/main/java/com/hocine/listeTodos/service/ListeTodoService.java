package com.hocine.listeTodos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hocine.listeTodos.DAO.IlisteTodosDao;
import com.hocine.listeTodos.Entity.ListeTodos;

@Service
public class ListeTodoService implements ICrudService<ListeTodos, Long> {

	@Autowired
	IlisteTodosDao dao;
	
	@Override
	public List<ListeTodos> getAll() {
		return (List<ListeTodos>) dao.findAll();
	}

	@Override
	public ListeTodos findbyid(Long id) {
		return dao.findById(id).get();
	}

	@Override
	public ListeTodos add(ListeTodos entity) {
		return dao.save(entity);
	}

	@Override
	public ListeTodos update(ListeTodos entity) {
		return dao.save(entity);
	}

	@Override
	public void delete(ListeTodos entity) {
		dao.delete(entity);
	}

	@Override
	public void saveAll(Iterable<ListeTodos> entities) {
		dao.saveAll(entities);
	}

}
