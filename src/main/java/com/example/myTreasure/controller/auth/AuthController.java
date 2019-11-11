package com.example.myTreasure.controller.auth;

import com.example.myTreasure.domain.registration.UserAuth;
import com.example.myTreasure.service.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
    @Autowired
    private UserAuthService userAuthService;

    @GetMapping("/registration")
    public String registration(Model model){

        return "registration";
    }

    @PostMapping("/registration")
    public String addUserAuth(UserAuth userAuth, Model model){

        if (!userAuthService.addUserAuth(userAuth)){
            model.addAttribute("message","User exists");
            return "registration";
        }

        return "redirect:/login";
    }

    @GetMapping("/activate/{code}")
    public String activate(Model model, @PathVariable String code){
        boolean isActivated=userAuthService.activatedUser(code);
        if (isActivated){
            model.addAttribute("message","User success activated");
        }else{
            model.addAttribute("message","Activation code is not found");
        }

        return "login";
    }
}
