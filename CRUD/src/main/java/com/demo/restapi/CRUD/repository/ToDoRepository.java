package com.demo.restapi.CRUD.repository;

import com.demo.restapi.CRUD.model.ToDo;
import org.springframework.data.repository.CrudRepository;

public interface ToDoRepository extends CrudRepository<ToDo, Long> {
}
