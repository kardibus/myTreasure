package com.example.myTreasure.repository;

import com.example.myTreasure.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Users,String> {
}
