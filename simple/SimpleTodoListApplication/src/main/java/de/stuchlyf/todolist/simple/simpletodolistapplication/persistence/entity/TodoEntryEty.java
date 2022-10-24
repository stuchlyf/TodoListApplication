package de.stuchlyf.todolist.simple.simpletodolistapplication.persistence.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "todo_entry")
public class TodoEntryEty {

    @Id
    @Column(
            name = "id",
            updatable = false,
            unique = true,
            nullable = false,
            insertable = false
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "todo_entry_id_generator"
    )
    @SequenceGenerator(
            name = "todo_entry_id_generator",
            sequenceName = "todo_entry_id_generator"
    )
    private Long id;

    @Column(
            name = "title",
            unique = true,
            nullable = false,
            length = 50
    )
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "completed")
    private boolean completed;

    public TodoEntryEty(Long id, String title, String description, boolean completed) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.completed = completed;
    }

    public Long getId() {
        return id;
    }

    public TodoEntryEty withId(Long id) {
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public TodoEntryEty withTitle(String title) {
        return this;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public TodoEntryEty withDescription(String description) {
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public TodoEntryEty withCompleted(boolean completed) {
        return this;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public TodoEntryEty(String title, String description, boolean completed) {
        this.title = title;
        this.description = description;
        this.completed = completed;
    }

    public TodoEntryEty(String title, String description) {
        this.title = title;
        this.description = description;
        this.completed = false;
    }

    public TodoEntryEty() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TodoEntryEty that = (TodoEntryEty) o;
        return completed == that.completed && Objects.equals(id, that.id) && Objects.equals(title, that.title) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, completed);
    }

    @Override
    public String toString() {
        return "TodoEntryEty{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", completed=" + completed +
                '}';
    }
}
