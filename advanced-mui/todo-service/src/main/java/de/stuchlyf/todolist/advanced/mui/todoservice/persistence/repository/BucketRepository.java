package de.stuchlyf.todolist.advanced.mui.todoservice.persistence.repository;

import de.stuchlyf.todolist.advanced.mui.todoservice.persistence.entity.BucketEty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BucketRepository extends JpaRepository<BucketEty, Long> {

    BucketEty findBucketEtyByName(String name);

}