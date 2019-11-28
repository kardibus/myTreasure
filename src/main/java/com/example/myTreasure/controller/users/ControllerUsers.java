package com.example.myTreasure.controller.users;

import com.example.myTreasure.domain.devices.Device;
import com.example.myTreasure.domain.users.Users;
import com.example.myTreasure.repository.device.RepoDevice;
import com.example.myTreasure.repository.users.RepoUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ControllerUsers {
            @Autowired
            private RepoUsers repoUsers;
            @Autowired
            private RepoDevice repoDevice;

            @GetMapping("/users")
            public String usersAll(Model model){
                Iterable<Users> users = repoUsers.findAll();
                Iterable<Device> devices=repoDevice.findAll();
                model.addAttribute("devices",devices);
                model.addAttribute("users",users);
                return "users";
            }
}
