package de.stuchlyf.todolist.advanced.mui.todoservice.rest.todoentry.impl;

import de.stuchlyf.todolist.advanced.mui.todoservice.business.todoentry.TodoEntryService;
import de.stuchlyf.todolist.advanced.mui.todoservice.common.mapper.Mapper;
import de.stuchlyf.todolist.advanced.mui.todoservice.rest.data.TodoEntryTo;
import de.stuchlyf.todolist.advanced.mui.todoservice.rest.todoentry.TodoEntryController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.annotation.Nonnull;
import java.util.List;

@RestController
@RequestMapping("todo-entry-service")
public class TodoEntryControllerImpl implements TodoEntryController {

    private final TodoEntryService todoEntrySvc;

    private final Mapper mapper;

    public TodoEntryControllerImpl(TodoEntryService todoEntrySvc, Mapper mapper) {
        this.todoEntrySvc = todoEntrySvc;
        this.mapper = mapper;
    }


    @Override
    @GetMapping("todos")
    public ResponseEntity<List<TodoEntryTo>> getAllTodos() {
        var todoBos = todoEntrySvc
                .getAllTodos();

        return ResponseEntity
                .ok(mapper.mapTodoEntryBosToTodoEntryTos(todoBos));
    }

    @Override
    @GetMapping("todos/{id}")
    public ResponseEntity<TodoEntryTo> getTodoById(
            @Nonnull @PathVariable(name = "id") Long id
    ) {
        var todoBo = todoEntrySvc
                .getTodoById(id);

        return ResponseEntity
                .ok(mapper.mapTodoEntryBoToTodoEntryTo(todoBo));
    }

    @Override
    @PostMapping("todos")
    public ResponseEntity<TodoEntryTo> createTodo(
            @Nonnull @RequestBody TodoEntryTo todoEntry
    ) {
        var todoBo = todoEntrySvc
                .createTodo(mapper.mapTodoEntryToToTodoEntryBo(todoEntry));

        return ResponseEntity
                .created(
                        ServletUriComponentsBuilder
                                .fromCurrentRequest()
                                .path("/{id}")
                                .buildAndExpand(todoBo.getId())
                                .toUri()
                )
                .body(mapper.mapTodoEntryBoToTodoEntryTo(todoBo));
    }

    @Override
    @PutMapping("todos/{id}")
    public ResponseEntity<TodoEntryTo> updateTodo(
            @Nonnull @PathVariable(name = "id") Long id,
            @Nonnull @RequestBody TodoEntryTo todoEntry
    ) {
        var todoBo = todoEntrySvc
                .updateTodo(id, mapper.mapTodoEntryToToTodoEntryBo(todoEntry));

        return ResponseEntity
                .status(HttpStatus.OK)
                .location(
                        ServletUriComponentsBuilder
                                .fromCurrentRequest()
                                .build()
                                .toUri()
                )
                .body(mapper.mapTodoEntryBoToTodoEntryTo(todoBo));
    }

    @Override
    @DeleteMapping("todos/{id}")
    public ResponseEntity<Void> deleteTodo(
            @Nonnull @PathVariable(name = "id") Long id
    ) {
        todoEntrySvc.deleteTodo(id);

        return ResponseEntity.noContent().build();
    }
}
