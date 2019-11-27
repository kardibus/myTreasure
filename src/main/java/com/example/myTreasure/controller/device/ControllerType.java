package com.example.myTreasure.controller.device;

import com.example.myTreasure.domain.devices.TypeDevice;
import com.example.myTreasure.repository.device.TypeDeviceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControllerType {
    @Autowired
    private TypeDeviceRepo typeDeviceRepo;

    @GetMapping("/type")
    public String allType(Model mode){
        Iterable<TypeDevice> type=typeDeviceRepo.findAll();
        mode.addAttribute("type",type);
        return "type";
    }

    @PostMapping("/deleteType/{id}")
    public String deleteType(@PathVariable(value = "id",required = false) Long id, Model model){
        typeDeviceRepo.deleteById(id);
        Iterable<TypeDevice> type=typeDeviceRepo.findAll();
        model.addAttribute("type",type);
        return "type";
    }

    @PostMapping("/createType")
    public String createType(@RequestParam(name = "type") String type1, Model model){
        TypeDevice typeDevice=new TypeDevice(type1);
        typeDeviceRepo.save(typeDevice);
        Iterable<TypeDevice> type=typeDeviceRepo.findAll();
        model.addAttribute("type",type);
        return "type";
    }

    @PostMapping("/searchType")
    public String searchType(@RequestParam(name="search") String search,Model model){
        Iterable<TypeDevice> type = typeDeviceRepo.findAll();

        if(search!=null && !search.isEmpty()){
            type=typeDeviceRepo.findByTypeLike("%"+search+"%");
        }else {
            type = typeDeviceRepo.findAll();
        }
        model.addAttribute("type",type);
        return "type";
    }

    @PostMapping("/updateType/{id}")
    public String updateType(@PathVariable(value = "id",required = false) TypeDevice typeDevice,
                              @RequestParam("type") String types,
                              Model model){

        typeDevice.setType(types);
        typeDeviceRepo.save(typeDevice);
        Iterable<TypeDevice> type=typeDeviceRepo.findAll();
        model.addAttribute("type",type);
        return "type";
    }
}
