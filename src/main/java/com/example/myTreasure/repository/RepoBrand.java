package com.example.myTreasure.repository;

import com.example.myTreasure.domain.Brand;
import org.springframework.data.repository.CrudRepository;

public interface RepoBrand extends CrudRepository<Brand,Long> {

    Iterable<Brand> findByBrandLike(String s);

}
