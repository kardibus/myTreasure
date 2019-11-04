package com.example.myTreasure.controller.auth;

import com.example.myTreasure.domain.Role;
import com.example.myTreasure.domain.UserAuth;
import com.example.myTreasure.repository.auth.UserAuthRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Set;

@Controller
public class AuthController {
    @Autowired
    private UserAuthRepo userAuthRepo;

    @GetMapping("/registration")
    public String registration(Model model){
        model.addAttribute("message","Create User");
        return "registration";
    }
    @PostMapping("/registration")
    public String addUserAuth(UserAuth userAuth, Model model){
        UserAuth userAuth1=userAuthRepo.findByUsername(userAuth.getUsername());
        if (userAuth1 != null){
            model.addAttribute("message","User exists");
            return "registration";
        }

        userAuth.setActive(true);
        userAuth.setRoles(Collections.singleton(Role.USER));
        userAuthRepo.save(userAuth);
        return "redirect:/login";
    }
}
