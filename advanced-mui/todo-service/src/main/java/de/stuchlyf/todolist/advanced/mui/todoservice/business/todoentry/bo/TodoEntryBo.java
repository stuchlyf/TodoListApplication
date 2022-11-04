package de.stuchlyf.todolist.advanced.mui.todoservice.business.todoentry.bo;

import de.stuchlyf.todolist.advanced.mui.todoservice.business.bucket.bo.BucketBo;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@With
@ToString
@EqualsAndHashCode
public class TodoEntryBo {

    private Long id;
    private String title;
    private String description;
    private boolean completed;
    private BucketBo bucketBo;

}
