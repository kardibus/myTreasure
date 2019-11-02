package com.example.myTreasure.config;

import com.example.myTreasure.domain.User;
import com.example.myTreasure.repository.UserRepo;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import java.time.LocalDateTime;

@Configuration
@EnableOAuth2Sso
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .mvcMatchers("/")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .csrf()
                .disable();

    }

    @Bean
    public PrincipalExtractor principalExtractor(UserRepo userRepo){
        return map -> {
            String id= (String) map.get("sub");
            User user= userRepo.findById(id).orElseGet(() -> {
                User newuser=new User();
                newuser.setId(id);
                newuser.setName((String) map.get("name"));
                newuser.setEmail((String) map.get("email"));
                newuser.setGender((String) map.get("gender"));
                newuser.setLocale((String) map.get("locale"));
                newuser.setUserpic((String) map.get("picture"));
                return newuser;
            });
            user.setLastVisit(LocalDateTime.now());
            return   userRepo.save(user);
        };
    }
}
