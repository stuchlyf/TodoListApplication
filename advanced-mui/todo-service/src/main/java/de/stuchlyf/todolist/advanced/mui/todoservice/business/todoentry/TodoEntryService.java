package de.stuchlyf.todolist.advanced.mui.todoservice.business.todoentry;

import de.stuchlyf.todolist.advanced.mui.todoservice.business.todoentry.bo.TodoEntryBo;

import java.util.List;

public interface TodoEntryService {


    List<TodoEntryBo> getAllTodos();

    TodoEntryBo getTodoById(Long id);

    TodoEntryBo createTodo(TodoEntryBo todoEntry);

    TodoEntryBo updateTodo(Long id, TodoEntryBo todoEntry);

    void deleteTodo(Long id);
}
