package com.example.myTreasure.repository.device;

import com.example.myTreasure.domain.devices.Model;
import org.springframework.data.repository.CrudRepository;

public interface RepoModel extends CrudRepository<Model,Long> {

    Iterable<Model> findByModelLike(String s);
}
