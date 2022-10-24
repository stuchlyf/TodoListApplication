package de.stuchlyf.todolist.simple.simpletodolistapplication.business;

import de.stuchlyf.todolist.simple.simpletodolistapplication.exception.DataNotFoundException;
import de.stuchlyf.todolist.simple.simpletodolistapplication.exception.ValidationException;
import de.stuchlyf.todolist.simple.simpletodolistapplication.persistence.entity.TodoEntryEty;
import de.stuchlyf.todolist.simple.simpletodolistapplication.persistence.repostory.TodoEntryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final TodoEntryRepository todoEntryRepository;

    public TodoService(TodoEntryRepository todoEntryRepository) {
        this.todoEntryRepository = todoEntryRepository;
    }

    public List<TodoEntryEty> getTodos() {
        return todoEntryRepository.findAll();
    }

    public TodoEntryEty getTodoById(Long id) throws DataNotFoundException {
        return todoEntryRepository
                .findById(id)
                .orElseThrow(DataNotFoundException::new);
    }

    public TodoEntryEty saveTodo(TodoEntryEty todo) {
        try {
            return todoEntryRepository
                    .save(todo);
        } catch (Exception e) {
            throw new ValidationException();
        }
    }

    public TodoEntryEty updateTodo(Long id, TodoEntryEty newTodo) {
        var todo = todoEntryRepository
                .findById(id)
                .orElseThrow(DataNotFoundException::new)
                .withTitle(newTodo.getTitle())
                .withDescription(newTodo.getDescription())
                .withCompleted(newTodo.isCompleted());

        return todoEntryRepository
                .save(todo);
    }

    public void deleteTodo(Long id) {
        todoEntryRepository
                .deleteById(id);
    }
}
