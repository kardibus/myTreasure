package com.example.myTreasure.repository.auth;

import com.example.myTreasure.domain.UserAuth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAuthRepo extends JpaRepository<UserAuth,Long> {
    UserAuth findByUsername (String username);
}
