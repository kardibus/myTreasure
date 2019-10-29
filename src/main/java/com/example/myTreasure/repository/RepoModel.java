package com.example.myTreasure.repository;

import com.example.myTreasure.domain.Model;
import org.springframework.data.repository.CrudRepository;

public interface RepoModel extends CrudRepository<Model,Long> {

    Iterable<Model> findByModelLike(String s);
}
