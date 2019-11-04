package com.example.myTreasure.controller.device;

import com.example.myTreasure.repository.device.RepoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControllerModel {
    @Autowired
    private RepoModel repoModel;

    @GetMapping("/model")
    public String allDevice(Model model) {
        Iterable<com.example.myTreasure.domain.device.Model> models = repoModel.findAll();
        model.addAttribute("models", models);
        return "model";
    }

    @PostMapping("/deleteModel/{id}")
    public String deleteBrand(@PathVariable(value = "id",required = false) Long id, Model model){
        repoModel.deleteById(id);
        Iterable<com.example.myTreasure.domain.device.Model> models=repoModel.findAll();
        model.addAttribute("models",models);
        return "model";
    }

    @PostMapping("/createModel")
    public String createBrand(@RequestParam(name = "model") String modelstr, Model model){
        com.example.myTreasure.domain.device.Model model1=new com.example.myTreasure.domain.device.Model(modelstr);
        repoModel.save(model1);
        Iterable<com.example.myTreasure.domain.device.Model> models=repoModel.findAll();
        model.addAttribute("models",models);
        return "model";
    }

    @PostMapping("/searchModel")
    public String searchBrand(@RequestParam(name="searchModel") String search,Model model){
        Iterable<com.example.myTreasure.domain.device.Model> models = repoModel.findAll();

        if(search!=null && !search.isEmpty()){
            models=repoModel.findByModelLike("%"+search+"%");
        }else {
            models = repoModel.findAll();
        }
        model.addAttribute("models",models);
        return "model";
    }

    @PostMapping("/updateModel/{id}")
    public String updateBrand(@PathVariable(value = "id",required = false) com.example.myTreasure.domain.device.Model modelId,
                              @RequestParam("model") String model1,
                              Model model){
        modelId.setModel(model1);
        repoModel.save(modelId);
        Iterable<com.example.myTreasure.domain.device.Model> models=repoModel.findAll();
        model.addAttribute("models",models);
        return "model";
    }
}
