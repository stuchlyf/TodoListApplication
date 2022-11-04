package de.stuchlyf.todolist.advanced.mui.todoservice.rest.bucket;

import de.stuchlyf.todolist.advanced.mui.todoservice.rest.data.BucketTo;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BucketController {

    ResponseEntity<List<BucketTo>> getAllBuckets();

    ResponseEntity<BucketTo> getBucketById(Long id);

    ResponseEntity<BucketTo> createBucket(BucketTo bucket);

    ResponseEntity<BucketTo> updateBucket(Long id, BucketTo bucket);

    ResponseEntity<Void> deleteBucket(Long id);
}
