package de.stuchlyf.todolist.advanced.mui.todoservice.business.bucket.impl;

import de.stuchlyf.todolist.advanced.mui.todoservice.business.bucket.BucketService;
import de.stuchlyf.todolist.advanced.mui.todoservice.business.bucket.bo.BucketBo;
import de.stuchlyf.todolist.advanced.mui.todoservice.business.exception.DataNotFoundException;
import de.stuchlyf.todolist.advanced.mui.todoservice.common.mapper.Mapper;
import de.stuchlyf.todolist.advanced.mui.todoservice.persistence.repository.BucketRepository;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public class BucketServiceImpl implements BucketService {

    private final BucketRepository bucketRepo;

    private final Mapper mapper;

    public BucketServiceImpl(BucketRepository bucketRepo, Mapper mapper) {
        this.bucketRepo = bucketRepo;
        this.mapper = mapper;
    }

    @Override
    public List<BucketBo> getAllBuckets() {
        var bucketEties = bucketRepo
                .findAll();

        return mapper.mapBucketEtiesToBucketBos(bucketEties);
    }

    @Override
    public BucketBo getBucketById(Long id) throws DataNotFoundException {
        var bucketEty = bucketRepo
                .findById(id)
                .orElseThrow(DataNotFoundException::new);

        return mapper.mapBucketEtyToBucketBo(bucketEty);
    }

    @Override
    public BucketBo createBucket(BucketBo bucket) {
        // TODO: Validation of `bucket`
        var bucketEty = bucketRepo
                .save(mapper.mapBucketBoToBucketEty(bucket));

        return mapper.mapBucketEtyToBucketBo(bucketEty);
    }

    @Override
    public BucketBo updateBucket(Long id, @Valid BucketBo bucket) throws DataNotFoundException {
        var bucketEty = bucketRepo
                .findById(id)
                .orElseThrow(DataNotFoundException::new)
                .withName(bucket.getName())
                .withTodoEntries(mapper.mapTodoEntryBosToTodoEntryEties(bucket.getTodoEntries()));

        return mapper.mapBucketEtyToBucketBo(bucketEty);
    }

    @Override
    public void deleteBucket(Long id) {
        if (!bucketRepo.existsById(id)) throw new DataNotFoundException();

        bucketRepo.deleteById(id);
    }
}
