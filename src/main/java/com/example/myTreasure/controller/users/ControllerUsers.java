package com.example.myTreasure.controller.users;

import com.example.myTreasure.domain.devices.Brand;
import com.example.myTreasure.domain.devices.Device;
import com.example.myTreasure.domain.devices.TypeDevice;
import com.example.myTreasure.domain.registration.UserAuth;
import com.example.myTreasure.domain.users.Users;
import com.example.myTreasure.repository.device.RepoDevice;
import com.example.myTreasure.repository.users.RepoUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


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

    @PostMapping("/deleteUsers/{id}")
    public String deleteUsers(@PathVariable(value = "id",required = false) Long id, Model model){
        repoUsers.deleteById(id);
        Iterable<Users> user = repoUsers.findAll();
        Iterable<Device> devices=repoDevice.findAll();
        model.addAttribute("devices",devices);
        model.addAttribute("users",user);
        return "users";
    }
    @PostMapping("/createUsers")
    public String createUsers(@RequestParam(name = "surname") String surname,
                               @RequestParam(name = "name") String name,
                               @RequestParam(name = "patronymic") String patronymic,
                               @RequestParam(name = "numberOne") Long numberOne,
                               @RequestParam(name = "numberTwo") Long numberTwo,
                               @RequestParam(name = "numberThree") Long numberThree,
                               @RequestParam(name = "device") Device device,
                               Model model){
        Users users=new Users();
        users.setSurname(surname);
        users.setName(name);
        users.setPatronymic(patronymic);
        users.setNumberOne(numberOne);
        users.setNumberTwo(numberTwo);
        users.setNumberThree(numberThree);
        users.setDevice(device);
        repoUsers.save(users);

        Iterable<Users> user = repoUsers.findAll();
        Iterable<Device> devices=repoDevice.findAll();
        model.addAttribute("devices",devices);
        model.addAttribute("users",user);
        return "users";
    }

    @PostMapping("/updateUsers/{id}")
    public String updateBrand(@PathVariable(value = "id",required = false) Users usersId,
                              @RequestParam("surname") String surname,
                              @RequestParam("name") String name,
                              @RequestParam("patronymic") String patronymic,
                              @RequestParam("numberOne") Long numberOne,
                              @RequestParam("numberTwo") Long numberTwo,
                              @RequestParam("numberThree") Long numberThree,
                              @RequestParam("device") Device device,
                              Model model){
        usersId.setSurname(surname);
        usersId.setName(name);
        usersId.setPatronymic(patronymic);
        usersId.setNumberOne(numberOne);
        usersId.setNumberTwo(numberTwo);
        usersId.setNumberThree(numberThree);
        usersId.setDevice(device);
        repoUsers.save(usersId);

        Iterable<Users> user = repoUsers.findAll();
        Iterable<Device> devices=repoDevice.findAll();
        model.addAttribute("devices",devices);
        model.addAttribute("users",user);
        return "users";
    }
}
