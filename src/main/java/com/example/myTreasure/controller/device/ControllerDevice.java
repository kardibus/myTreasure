package com.example.myTreasure.controller.device;

import com.example.myTreasure.domain.devices.TypeDevice;
import com.example.myTreasure.domain.registration.UserAuth;
import com.example.myTreasure.domain.devices.Brand;
import com.example.myTreasure.domain.devices.Device;
import com.example.myTreasure.repository.device.RepoBrand;
import com.example.myTreasure.repository.device.RepoDevice;
import com.example.myTreasure.repository.device.RepoModel;
import com.example.myTreasure.repository.device.TypeDeviceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControllerDevice {

    @Autowired
    private RepoDevice repoDevice;
    @Autowired
    private RepoModel repoModel;
    @Autowired
    private RepoBrand repoBrand;
    @Autowired
    private TypeDeviceRepo typeDeviceRepo;


    @GetMapping("/")
    public String allDevice(Model model){
        return getString(model);
    }

    @PostMapping("/deleteDevice/{id}")
    public String deleteDevice(@PathVariable(value = "id",required = false) Long id, Model model){
        repoDevice.deleteById(id);
        return getString(model);
    }

    @PostMapping("/createDevice")
    public String createDevice(@AuthenticationPrincipal UserAuth userAuth,
                              @RequestParam(name = "serial") String serial,
                              @RequestParam(name = "brand") Brand brand,
                              @RequestParam(name = "model") com.example.myTreasure.domain.devices.Model models,
                              @RequestParam(name = "types") TypeDevice types,
                              Model model){
        Device device=new Device();
        device.setSerial(serial);
        device.setBrand(brand);
        device.setModel(models);
        device.setTypeDevice(types);
        device.setUserAuth(userAuth);
        repoDevice.save(device);
        return getString(model);
    }

    @PostMapping("/searchDevice")
    public String searchDevice(@RequestParam(name="searchDevice") String search,Model model){
        Iterable<Device> devices =repoDevice.findAll();
        Iterable<Brand> brands=repoBrand.findAll();
        Iterable<TypeDevice> types=typeDeviceRepo.findAll();
        Iterable<com.example.myTreasure.domain.devices.Model> models=repoModel.findAll();

        if(search!=null){
            devices=repoDevice.findBySerialLike("%"+search+"%");
        }else {
            devices = repoDevice.findAll();
        }

        model.addAttribute("types",types);
        model.addAttribute("models",models);
        model.addAttribute("brands",brands);
        model.addAttribute("devices",devices);
        return "index";
    }

    @PostMapping("/updateDevice/{id}")
    public String updateBrand(@PathVariable(value = "id",required = false) Device deviceId,
                              @RequestParam("deviceSerial") String serial,
                              @RequestParam("deviceModel") com.example.myTreasure.domain.devices.Model models,
                              @RequestParam("deviceBrand") Brand brand,
                              @RequestParam("deviceType") TypeDevice types,
                              Model model){
        deviceId.setSerial(serial);
        deviceId.setModel(models);
        deviceId.setBrand(brand);
        deviceId.setTypeDevice(types);
        repoDevice.save(deviceId);

        return getString(model);
    }

    private String getString(Model model) {
        Iterable<Device> devices=repoDevice.findAll();
        Iterable<Brand> brands=repoBrand.findAll();
        Iterable<TypeDevice> types=typeDeviceRepo.findAll();
        Iterable<com.example.myTreasure.domain.devices.Model> models=repoModel.findAll();
        model.addAttribute("models",models);
        model.addAttribute("brands",brands);
        model.addAttribute("devices",devices);
        model.addAttribute("types",types);
        return "index";
    }
}
