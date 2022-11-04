package de.stuchlyf.todolist.advanced.mui.todoservice.persistence.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.FetchType.LAZY;

@Entity(name = "Bucket")
@Table(name = "bucket")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@With
@ToString
public class BucketEty {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bucket_id_gen")
    @SequenceGenerator(name = "bucket_id_gen", sequenceName = "bucket_id_gen")
    @Column(name = "id", updatable = false, unique = true, insertable = false, nullable = false)
    private Long id;

    @NotEmpty
    @NotNull
    @Column(name = "name", nullable = false, unique = true, insertable = false)
    private String name;

    @OneToMany(fetch = LAZY)
    @ToString.Exclude
    private Set<TodoEntryEty> todoEntries = new HashSet<>();
}
