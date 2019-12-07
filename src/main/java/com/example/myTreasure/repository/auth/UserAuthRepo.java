package com.example.myTreasure.repository.auth;

import com.example.myTreasure.domain.registration.UserAuth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAuthRepo extends JpaRepository<UserAuth,Long> {
    UserAuth findByUsername (String username);
    UserAuth findByActivationCode(String code);
    UserAuth findByEmail(String email);
}
