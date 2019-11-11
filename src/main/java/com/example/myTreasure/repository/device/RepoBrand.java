package com.example.myTreasure.repository.device;

import com.example.myTreasure.domain.devices.Brand;
import org.springframework.data.repository.CrudRepository;

public interface RepoBrand extends CrudRepository<Brand,Long> {

    Iterable<Brand> findByBrandLike(String s);

}
