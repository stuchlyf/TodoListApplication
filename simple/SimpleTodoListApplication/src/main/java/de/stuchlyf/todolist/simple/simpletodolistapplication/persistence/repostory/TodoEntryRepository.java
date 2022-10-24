package de.stuchlyf.todolist.simple.simpletodolistapplication.persistence.repostory;

import de.stuchlyf.todolist.simple.simpletodolistapplication.persistence.entity.TodoEntryEty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoEntryRepository extends JpaRepository<TodoEntryEty, Long> {
}