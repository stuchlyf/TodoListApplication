package de.stuchlyf.todolist.advanced.mui.todoservice.business.todoentry.impl;

import de.stuchlyf.todolist.advanced.mui.todoservice.business.todoentry.TodoEntryService;
import de.stuchlyf.todolist.advanced.mui.todoservice.business.todoentry.bo.TodoEntryBo;
import de.stuchlyf.todolist.advanced.mui.todoservice.business.exception.DataNotFoundException;
import de.stuchlyf.todolist.advanced.mui.todoservice.common.mapper.Mapper;
import de.stuchlyf.todolist.advanced.mui.todoservice.persistence.repository.TodoEntryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoEntryServiceImpl implements TodoEntryService {

    private final TodoEntryRepository todoEntryRepo;

    private final Mapper mapper;

    public TodoEntryServiceImpl(TodoEntryRepository todoEntryRepo, Mapper mapper) {
        this.todoEntryRepo = todoEntryRepo;
        this.mapper = mapper;
    }

    @Override
    public List<TodoEntryBo> getAllTodos() {
        var todoEties = todoEntryRepo.findAll();

        return mapper.mapTodoEntryEtiesToTodoEntryBos(todoEties);
    }

    @Override
    public TodoEntryBo getTodoById(Long id) throws DataNotFoundException {
        var todoEty = todoEntryRepo
                .findById(id)
                .orElseThrow(DataNotFoundException::new);

        return mapper.mapTodoEntryEtyToTodoEntryBo(todoEty);
    }

    @Override
    public TodoEntryBo createTodo(TodoEntryBo todoEntry) {
        // TODO: Validation of `todoEntry`
        var todoEty = todoEntryRepo
                .save(mapper.mapTodoEntryBoToTodoEntryEty(todoEntry));

        return mapper.mapTodoEntryEtyToTodoEntryBo(todoEty);
    }

    @Override
    public TodoEntryBo updateTodo(Long id, TodoEntryBo todoEntry) throws DataNotFoundException {
        // TODO: Validation of `todoEntry`

        var todoEty = todoEntryRepo
                .findById(id)
                .orElseThrow(DataNotFoundException::new)
                .withTitle(todoEntry.getTitle())
                .withDescription(todoEntry.getDescription())
                .withCompleted(todoEntry.isCompleted());

        return mapper.mapTodoEntryEtyToTodoEntryBo(todoEntryRepo.save(todoEty));
    }

    @Override
    public void deleteTodo(Long id) throws DataNotFoundException {
        if (!todoEntryRepo.existsById(id)) throw new DataNotFoundException();

        todoEntryRepo.deleteById(id);
    }
}
