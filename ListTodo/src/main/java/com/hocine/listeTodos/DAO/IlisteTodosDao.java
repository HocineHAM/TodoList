package com.hocine.listeTodos.DAO;

import org.springframework.data.repository.CrudRepository;

import com.hocine.listeTodos.Entity.ListeTodos;

public interface IlisteTodosDao extends CrudRepository<ListeTodos, Long>{

}
