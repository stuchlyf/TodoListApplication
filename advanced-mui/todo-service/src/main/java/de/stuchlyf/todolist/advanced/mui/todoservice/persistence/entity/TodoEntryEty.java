package de.stuchlyf.todolist.advanced.mui.todoservice.persistence.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity(name = "TodoEntry")
@Table(name = "todo_entry")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@With
@ToString
public class TodoEntryEty {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "todo_entry_id_gen")
    @SequenceGenerator(name = "todo_entry_id_gen", sequenceName = "todo_entry_id_gen")
    @Column(name = "id", updatable = false, unique = true, insertable = false, nullable = false)
    private Long id;


    @Column(name = "title", length = 50, nullable = false)
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "completed")
    private boolean completed;

    @NotNull
    @ManyToOne
    @JoinColumn
    private BucketEty bucket;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TodoEntryEty that = (TodoEntryEty) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
