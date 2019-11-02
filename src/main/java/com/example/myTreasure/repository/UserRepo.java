package com.example.myTreasure.repository;

import com.example.myTreasure.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,String> {
}
