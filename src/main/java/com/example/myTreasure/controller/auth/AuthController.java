package com.example.myTreasure.controller.auth;

import com.example.myTreasure.domain.registration.UserAuth;
import com.example.myTreasure.repository.auth.UserAuthRepo;
import com.example.myTreasure.service.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {
    @Autowired
    private UserAuthService userAuthService;
    @Autowired
    private UserAuthRepo userAuthRepo;

    @GetMapping("/registration")
    public String registration(Model model){

        return "login";
    }

    @PostMapping("/registration")
    public String addUserAuth(UserAuth userAuth, Model model){

        if (!userAuthService.addUserAuth(userAuth)){
          //  model.addAttribute("message","User exists");
            return "login";
        }

        return "redirect:/login";
    }

    @GetMapping("/activate/{code}")
    public String activate(Model model, @PathVariable String code){
        boolean isActivated=userAuthService.activatedUser(code);
        if (isActivated){
            model.addAttribute("message","User success activated");
            return "redirect:/users";
        }else{
            model.addAttribute("message","Activation code is not found");
        }

        return "login";
    }

    @PostMapping("/forgotpassword")
    public String forgotPass(Model model, @RequestParam("email") String email){
        boolean isEmail=userAuthService.checkEmail(email);

        if (isEmail){
            userAuthService.sendUserPass(email);
            return "redirect:/login";
        }

        return "emailforgot";
    }

    @GetMapping("/emailforgot")
    public String forgot(){
        return "emailforgot";
    }
}
