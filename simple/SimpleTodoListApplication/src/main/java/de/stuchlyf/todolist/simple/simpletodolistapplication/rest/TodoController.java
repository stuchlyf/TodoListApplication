package de.stuchlyf.todolist.simple.simpletodolistapplication.rest;

import de.stuchlyf.todolist.simple.simpletodolistapplication.business.TodoService;
import de.stuchlyf.todolist.simple.simpletodolistapplication.exception.DataNotFoundException;
import de.stuchlyf.todolist.simple.simpletodolistapplication.exception.ValidationException;
import de.stuchlyf.todolist.simple.simpletodolistapplication.persistence.entity.TodoEntryEty;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("todo-controller")
public class TodoController {

    private final TodoService todoSvc;

    public TodoController(TodoService todoSvc) {
        this.todoSvc = todoSvc;
    }

    @GetMapping("todos")
    public ResponseEntity<List<TodoEntryEty>> getTodos() {
        return new ResponseEntity<>(todoSvc.getTodos(), HttpStatus.OK);
    }

    @GetMapping("todos/{id}")
    public ResponseEntity<TodoEntryEty> getTodoById(@PathVariable("id") Long id) {
        try {
            return new ResponseEntity<>(todoSvc.getTodoById(id), HttpStatus.OK);
        } catch (DataNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("todos")
    public ResponseEntity<TodoEntryEty> createTodo(@RequestBody TodoEntryEty todo) {
        try {
            return new ResponseEntity<>(todoSvc.saveTodo(todo), HttpStatus.CREATED);
        } catch (ValidationException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("todo/{id}")
    public ResponseEntity<TodoEntryEty> updateTodo(@PathVariable Long id, @RequestBody TodoEntryEty todo) {
        try {
            return new ResponseEntity<>(todoSvc.updateTodo(id, todo), HttpStatus.OK);
        } catch (DataNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (ValidationException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
