package com.demo.restapi.CRUD.service;

import com.demo.restapi.CRUD.model.ToDo;
import com.demo.restapi.CRUD.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ToDoServiceImpl implements ToDoService{


    @Autowired
    ToDoRepository repository;


    @Override
    public List<ToDo> getTodos() {
        List<ToDo> todo = new ArrayList<>();
        repository.findAll().forEach(todo::add);
        return todo;

    }

    @Override
    public ToDo getTodoById(Long id) {

        return repository.findById(id).get();
    }

    @Override
    public ToDo insert(ToDo todo) {
        return repository.save(todo);

    }

    @Override
    public void updateTodo(Long id, ToDo todo) {
        ToDo todoFromDb = repository.findById(id).get();
        System.out.println(todoFromDb.toString());
        todoFromDb.setTodoStatus(todo.getTodoStatus());
        todoFromDb.setDescription(todo.getDescription());
        todoFromDb.setTitle(todo.getTitle());
        repository.save(todoFromDb);
    }

    @Override
    public void deleteTodo(Long todoId) {
        repository.deleteById(todoId);
    }
}
