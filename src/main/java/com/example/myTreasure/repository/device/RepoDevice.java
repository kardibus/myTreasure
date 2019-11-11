package com.example.myTreasure.repository.device;

import com.example.myTreasure.domain.devices.Device;
import org.springframework.data.repository.CrudRepository;

public interface RepoDevice extends CrudRepository<Device,Long> {
    Iterable<Device> findBySerialLike(String s);
}
