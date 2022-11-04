package de.stuchlyf.todolist.advanced.mui.todoservice.common.mapper;

import de.stuchlyf.todolist.advanced.mui.todoservice.business.bucket.bo.BucketBo;
import de.stuchlyf.todolist.advanced.mui.todoservice.business.todoentry.bo.TodoEntryBo;
import de.stuchlyf.todolist.advanced.mui.todoservice.persistence.entity.BucketEty;
import de.stuchlyf.todolist.advanced.mui.todoservice.persistence.entity.TodoEntryEty;
import de.stuchlyf.todolist.advanced.mui.todoservice.rest.data.BucketTo;
import de.stuchlyf.todolist.advanced.mui.todoservice.rest.data.TodoEntryTo;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapping;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@org.mapstruct.Mapper(componentModel = "spring")
public interface Mapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "completed", target = "completed")
    TodoEntryEty mapTodoEntryBoToTodoEntryEty(TodoEntryBo source);

    @InheritInverseConfiguration
    TodoEntryBo mapTodoEntryEtyToTodoEntryBo(TodoEntryEty source);

    List<TodoEntryEty> mapTodoEntryBosToTodoEntryEties(List<TodoEntryBo> source);

    @InheritInverseConfiguration
    List<TodoEntryBo> mapTodoEntryEtiesToTodoEntryBos(List<TodoEntryEty> source);

    Set<TodoEntryEty> mapTodoEntryBosToTodoEntryEties(Set<TodoEntryBo> source);

    @InheritInverseConfiguration
    Set<TodoEntryBo> mapTodoEntryEtiesToTodoEntryBos(Set<TodoEntryEty> source);

    Collection<TodoEntryEty> mapTodoEntryBosToTodoEntryEties(Collection<TodoEntryBo> source);

    @InheritInverseConfiguration
    Collection<TodoEntryBo> mapTodoEntryEtiesToTodoEntryBos(Collection<TodoEntryEty> source);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "completed", target = "completed")
    TodoEntryBo mapTodoEntryToToTodoEntryBo(TodoEntryTo source);

    @InheritInverseConfiguration
    TodoEntryTo mapTodoEntryBoToTodoEntryTo(TodoEntryBo source);

    List<TodoEntryBo> mapTodoEntryTosToTodoEntryBos(List<TodoEntryTo> source);

    @InheritInverseConfiguration
    List<TodoEntryTo> mapTodoEntryBosToTodoEntryTos(List<TodoEntryBo> source);

    Set<TodoEntryBo> mapTodoEntryTosToTodoEntryBos(Set<TodoEntryTo> source);

    @InheritInverseConfiguration
    Set<TodoEntryTo> mapTodoEntryBosToTodoEntryTos(Set<TodoEntryBo> source);

    Collection<TodoEntryBo> mapTodoEntryTosToTodoEntryBos(Collection<TodoEntryTo> source);

    @InheritInverseConfiguration
    Collection<TodoEntryTo> mapTodoEntryBosToTodoEntryTos(Collection<TodoEntryBo> source);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "todoEntries", target = "todoEntries")
    BucketEty mapBucketBoToBucketEty(BucketBo source);

    @InheritInverseConfiguration
    BucketBo mapBucketEtyToBucketBo(BucketEty source);

    List<BucketEty> mapBucketBosToBucketEties(List<BucketBo> source);

    @InheritInverseConfiguration
    List<BucketBo> mapBucketEtiesToBucketBos(List<BucketEty> source);

    Set<BucketEty> mapBucketBosToBucketEties(Set<BucketBo> source);

    @InheritInverseConfiguration
    Set<BucketBo> mapBucketEtiesToBucketBos(Set<BucketEty> source);

    Collection<BucketEty> mapBucketBosToBucketEties(Collection<BucketBo> source);

    @InheritInverseConfiguration
    Collection<BucketBo> mapBucketEtiesToBucketBos(Collection<BucketEty> source);


    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "todoEntries", target = "todoEntries")
    BucketBo mapBucketToToBucketBo(BucketTo source);

    @InheritInverseConfiguration
    BucketTo mapBucketBoToBucketTo(BucketBo source);

    List<BucketBo> mapBucketTosToBucketBos(List<BucketTo> source);

    @InheritInverseConfiguration
    List<BucketTo> mapBucketBosToBucketTos(List<BucketBo> source);

    Set<BucketBo> mapBucketTosToBucketBos(Set<BucketTo> source);

    @InheritInverseConfiguration
    Set<BucketTo> mapBucketBosToBucketTos(Set<BucketBo> source);

    Collection<BucketBo> mapBucketTosToBucketBos(Collection<BucketTo> source);

    @InheritInverseConfiguration
    Collection<BucketTo> mapBucketBosToBucketTos(Collection<BucketBo> source);
}
