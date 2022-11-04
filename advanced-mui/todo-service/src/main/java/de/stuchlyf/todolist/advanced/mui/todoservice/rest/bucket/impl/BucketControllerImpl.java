package de.stuchlyf.todolist.advanced.mui.todoservice.rest.bucket.impl;

import de.stuchlyf.todolist.advanced.mui.todoservice.business.bucket.BucketService;
import de.stuchlyf.todolist.advanced.mui.todoservice.common.mapper.Mapper;
import de.stuchlyf.todolist.advanced.mui.todoservice.rest.bucket.BucketController;
import de.stuchlyf.todolist.advanced.mui.todoservice.rest.data.BucketTo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("bucket-service")
public class BucketControllerImpl implements BucketController {

    private final BucketService bucketSvc;
    private final Mapper mapper;

    public BucketControllerImpl(BucketService bucketSvc, Mapper mapper) {
        this.bucketSvc = bucketSvc;
        this.mapper = mapper;
    }

    @Override
    @GetMapping("buckets")
    public ResponseEntity<List<BucketTo>> getAllBuckets() {
        var bucketBos = bucketSvc
                .getAllBuckets();

        return ResponseEntity
                .ok(mapper.mapBucketBosToBucketTos(bucketBos));
    }

    @Override
    @GetMapping("buckets/{id}")
    public ResponseEntity<BucketTo> getBucketById(@PathVariable("id") Long id) {
        var bucketBo = bucketSvc
                .getBucketById(id);

        return ResponseEntity
                .ok(mapper.mapBucketBoToBucketTo(bucketBo));
    }

    @Override
    @PostMapping("buckets")
    public ResponseEntity<BucketTo> createBucket(@RequestBody BucketTo bucket) {
        var bucketBo = bucketSvc
                .createBucket(mapper.mapBucketToToBucketBo(bucket));

        return ResponseEntity
                .created(
                        ServletUriComponentsBuilder
                                .fromCurrentRequest()
                                .path("/{id}")
                                .buildAndExpand(bucketBo.getId())
                                .toUri()
                )
                .body(mapper.mapBucketBoToBucketTo(bucketBo));
    }

    @Override
    @PutMapping("bucket/{id}")
    public ResponseEntity<BucketTo> updateBucket(
            @PathVariable("id") Long id,
            @RequestBody BucketTo bucket
    ) {
        var bucketBo = bucketSvc
                .updateBucket(id, mapper.mapBucketToToBucketBo(bucket));

        return ResponseEntity
                .status(HttpStatus.OK)
                .location(
                        ServletUriComponentsBuilder
                                .fromCurrentRequest()
                                .build()
                                .toUri()
                )
                .body(mapper.mapBucketBoToBucketTo(bucketBo));
    }

    @Override
    @DeleteMapping("bucket/{id}")
    public ResponseEntity<Void> deleteBucket(@PathVariable("id") Long id) {
        bucketSvc.deleteBucket(id);

        return ResponseEntity
                .noContent()
                .build();
    }
}
