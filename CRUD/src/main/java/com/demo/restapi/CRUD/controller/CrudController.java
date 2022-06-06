package com.demo.restapi.CRUD.controller;

import com.demo.restapi.CRUD.model.ToDo;
import com.demo.restapi.CRUD.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/todo")
public class CrudController {
    @Autowired
    ToDoService toDoService;


    @GetMapping
    public ResponseEntity<List<ToDo>> getAllTodos() {
        List<ToDo> todos = toDoService.getTodos();
        return new ResponseEntity<>(todos, HttpStatus.OK);
    }
    //The function receives a GET request, processes it, and gives back a list of Todo as a response.
    @GetMapping({"/{todoId}"})
    public ResponseEntity<ToDo> getTodo(@PathVariable Long todoId) {
        return new ResponseEntity<>(toDoService.getTodoById(todoId), HttpStatus.OK);
    }
    //The function receives a POST request, processes it, creates a new Todo and saves it to the database, and returns a resource link to the created todo.           @PostMapping
    @PostMapping("/create")
    public ResponseEntity<ToDo> saveTodo(@RequestBody ToDo todo) {
        ToDo todo1 = toDoService.insert(todo);
        HttpHeaders httpHeaders = new HttpHeaders();
        return new ResponseEntity<>(todo1, HttpStatus.CREATED);
    }
    //The function receives a PUT request, updates the Todo with the specified Id and returns the updated Todo
    @PutMapping({"/{todoId}"})
    public ResponseEntity<ToDo> updateTodo(@PathVariable("todoId") Long todoId, @RequestBody ToDo todo) {
        toDoService.updateTodo(todoId, todo);
        return new ResponseEntity<>(toDoService.getTodoById(todoId), HttpStatus.OK);
    }
    //The function receives a DELETE request, deletes the Todo with the specified Id.
    @DeleteMapping({"/{todoId}"})
    public ResponseEntity<ToDo> deleteTodo(@PathVariable("todoId") Long todoId) {
        toDoService.deleteTodo(todoId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
