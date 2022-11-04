package de.stuchlyf.todolist.advanced.mui.todoservice.business.bucket;

import de.stuchlyf.todolist.advanced.mui.todoservice.business.bucket.bo.BucketBo;

import java.util.List;

public interface BucketService {

    List<BucketBo> getAllBuckets();

    BucketBo getBucketById(Long id);

    BucketBo createBucket(BucketBo bucket);

    BucketBo updateBucket(Long id, BucketBo bucket);

    void deleteBucket(Long id);
}
