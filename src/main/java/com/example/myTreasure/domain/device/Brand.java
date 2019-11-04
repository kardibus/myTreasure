package com.example.myTreasure.domain.device;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "brand")
public class Brand {

    public Brand(){}
    public Brand(String brand) {
        this.brand = brand;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long Id;

    public String brand;

    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<Device> device = new HashSet<Device>();

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
