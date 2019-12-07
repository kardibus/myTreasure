package com.example.myTreasure.controller.dateDev;

import com.example.myTreasure.domain.dateDev.DateDevice;
import com.example.myTreasure.repository.dateDev.RepoDateDev;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java.time.LocalDateTime.now;

@Controller
public class ControllerDateDev {
    @Autowired
    private RepoDateDev repoDateDev;

    @GetMapping("/datedev")
    public String DateAll(Model model){
        Iterable<DateDevice> dateDevices=repoDateDev.findAll();
        model.addAttribute("datedevices",dateDevices);
        return "datedev";
    }
    @PostMapping("/createDateDev")
    public String DateCreate(@RequestParam(name = "dateOpen") String dateOpen,
                             @RequestParam(name = "dateClose",defaultValue = "2019-12-01 21:09") String dateClose,
                             @RequestParam(name = "warranty",defaultValue = "2019-12-01 21:09") String warranty,
                             @RequestParam(name = "numberDay",defaultValue = "0") Long numberDay,
                             Model model){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateOp = LocalDateTime.parse(dateOpen, formatter);
        LocalDateTime dateCl = LocalDateTime.parse(dateClose, formatter);
        LocalDateTime dateWr = LocalDateTime.parse(warranty, formatter);


        dateWr=(dateCl.plusDays(numberDay));

        DateDevice dateDevice=new DateDevice();
        dateDevice.setDateOpen(dateOp);
        dateDevice.setDateClose(dateCl);
        dateDevice.setWarranty(dateWr);
        dateDevice.setNumberDay(numberDay);
        repoDateDev.save(dateDevice);

        Iterable<DateDevice> dateDevices=repoDateDev.findAll();
        model.addAttribute("datedevices",dateDevices);
        return "datedev";
    }
}
