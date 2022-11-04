package de.stuchlyf.todolist.advanced.mui.todoservice.business.bucket.bo;

import de.stuchlyf.todolist.advanced.mui.todoservice.business.todoentry.bo.TodoEntryBo;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@With
@ToString
@EqualsAndHashCode
public class BucketBo {

    private Long id;
    private String name;
    private Set<TodoEntryBo> todoEntries;

}
