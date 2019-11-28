package com.example.myTreasure.service;

import com.example.myTreasure.domain.registration.Role;
import com.example.myTreasure.domain.registration.UserAuth;
import com.example.myTreasure.repository.auth.UserAuthRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.UUID;

@Service
public class UserAuthService implements UserDetailsService {
    @Autowired
    private UserAuthRepo userAuthRepo;
    @Autowired
    private MailSender mailSender;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userAuthRepo.findByUsername(s);
    }

    public boolean addUserAuth(UserAuth userAuth){
        UserAuth userAuth1=userAuthRepo.findByUsername(userAuth.getUsername());

        if(userAuth1!=null){
            return false;
        }

        userAuth.setActive(true);
        userAuth.setRoles(Collections.singleton(Role.USER));
        userAuth.setActivationCode(UUID.randomUUID().toString());
        userAuthRepo.save(userAuth);

        if (!StringUtils.isEmpty(userAuth.getEmail())){
            String message=String.format("Hello, %s! \n" + "Welcome to myTreasure.Please,visit" +
                    "next link: http://mytreasure.herokuapp.com/activate/%s"
            ,userAuth.getUsername(),userAuth.getActivationCode());
            mailSender.send(userAuth.getEmail(),"Activation code",message);
        }

        return true;
    }

    public boolean activatedUser(String code) {
       UserAuth userAuth= userAuthRepo.findByActivationCode(code);

       if (userAuth==null){
           return false;
       }

       userAuth.setActivationCode(code);
       userAuthRepo.save(userAuth);
        return true;
    }
}
