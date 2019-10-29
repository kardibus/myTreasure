package com.example.myTreasure.controller;

import com.example.myTreasure.domain.Brand;
import com.example.myTreasure.repository.RepoBrand;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControllerBrand {
    @Autowired
    private RepoBrand repoBrand;

    @GetMapping("/brand")
    public String allBrand(Model model){
        Iterable<Brand> brands=repoBrand.findAll();
        model.addAttribute("brands",brands);
        return "brand";
    }

    @PostMapping("/delete/{id}")
    public String deleteBrand(@PathVariable(value = "id",required = false) Long id,Model model){
        repoBrand.deleteById(id);
        Iterable<Brand> brands=repoBrand.findAll();
        model.addAttribute("brands",brands);
        return "brand";
    }

    @PostMapping("/create")
    public String createBrand(@RequestParam(name = "brand") String brand, Model model){
        Brand brand1=new Brand(brand);
        repoBrand.save(brand1);
        Iterable<Brand> brands=repoBrand.findAll();
        model.addAttribute("brands",brands);
        return "brand";
    }

    @PostMapping("/search")
    public String searchBrand(@RequestParam(name="search") String search,Model model){
        Iterable<Brand> brands = repoBrand.findAll();

        if(search!=null && !search.isEmpty()){
            brands=repoBrand.findByBrandLike("%"+search+"%");
        }else {
            brands = repoBrand.findAll();
        }
        model.addAttribute("brands",brands);
        return "brand";
    }

    @PostMapping("/update/{id}")
    public String updateBrand(@PathVariable(value = "id",required = false) Brand brandId,
                              @RequestParam("brand") String brand,
                              Model model){
        brandId.setBrand(brand);
        repoBrand.save(brandId);
        Iterable<Brand> brands=repoBrand.findAll();
        model.addAttribute("brands",brands);
        return "brand";
    }
}
