package com.demo.restapi.CRUD.service;

import com.demo.restapi.CRUD.model.ToDo;

import java.util.List;

public interface ToDoService {

    List<ToDo> getTodos();

    ToDo getTodoById(Long id);

    ToDo insert(ToDo todo);

    void updateTodo(Long id, ToDo todo);

    void deleteTodo(Long todoId);
}
