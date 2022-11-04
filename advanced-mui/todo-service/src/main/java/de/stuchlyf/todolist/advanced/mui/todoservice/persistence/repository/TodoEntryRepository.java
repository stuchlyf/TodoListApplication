package de.stuchlyf.todolist.advanced.mui.todoservice.persistence.repository;

import de.stuchlyf.todolist.advanced.mui.todoservice.persistence.entity.TodoEntryEty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoEntryRepository extends JpaRepository<TodoEntryEty, Long> {
}