package de.stuchlyf.todolist.advanced.mui.todoservice.rest.todoentry;

import de.stuchlyf.todolist.advanced.mui.todoservice.rest.data.TodoEntryTo;
import org.springframework.http.ResponseEntity;

import javax.annotation.Nonnull;
import java.util.List;

public interface TodoEntryController {

    ResponseEntity<List<TodoEntryTo>> getAllTodos();

    ResponseEntity<TodoEntryTo> getTodoById(@Nonnull Long id);

    ResponseEntity<TodoEntryTo> createTodo(@Nonnull TodoEntryTo todoEntryTo);

    ResponseEntity<TodoEntryTo> updateTodo(@Nonnull Long id, @Nonnull TodoEntryTo todoEntryTo);

    ResponseEntity<Void> deleteTodo(@Nonnull Long id);
}
