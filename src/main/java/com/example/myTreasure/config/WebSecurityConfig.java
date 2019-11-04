package com.example.myTreasure.config;

import com.example.myTreasure.domain.Users;
import com.example.myTreasure.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import javax.sql.DataSource;
import java.time.LocalDateTime;

@Configuration

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .mvcMatchers("/login/","/registration")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/login/")
                .permitAll()
                .and()
                .logout()
                .permitAll().and().csrf().disable();

    }

//    @Bean
//    public PrincipalExtractor principalExtractor(UserRepo userRepo){
//        return map -> {
//            String id= (String) map.get("sub");
//            Users users = userRepo.findById(id).orElseGet(() -> {
//                Users newuser=new Users();
//                newuser.setId(id);
//                newuser.setName((String) map.get("name"));
//                newuser.setEmail((String) map.get("email"));
//                newuser.setGender((String) map.get("gender"));
//                newuser.setLocale((String) map.get("locale"));
//                newuser.setUserpic((String) map.get("picture"));
//                return newuser;
//            });
//            users.setLastVisit(LocalDateTime.now());
//            return   userRepo.save(users);
//        };
//    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(NoOpPasswordEncoder.getInstance())
                .usersByUsernameQuery("select username,password,active from user_auth where username=?")
                .authoritiesByUsernameQuery("select u.username,ur.roles from user_auth u inner join user_role ur on u.id=ur.user_id where u.username=?");
    }
}
