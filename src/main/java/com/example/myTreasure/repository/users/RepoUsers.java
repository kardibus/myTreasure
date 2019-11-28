package com.example.myTreasure.repository.users;

import com.example.myTreasure.domain.users.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoUsers extends JpaRepository<Users,Long> {

}
