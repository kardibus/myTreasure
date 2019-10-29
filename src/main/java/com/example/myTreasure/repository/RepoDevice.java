package com.example.myTreasure.repository;

import com.example.myTreasure.domain.Device;
import org.springframework.data.repository.CrudRepository;

public interface RepoDevice extends CrudRepository<Device,Long> {
    Iterable<Device> findBySerialLike(String s);
}
