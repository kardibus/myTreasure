package com.example.myTreasure.domain.device;

import com.example.myTreasure.domain.device.Device;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "model")
public class Model {

    public Model(){}
    public Model(String model) {
        this.model = model;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    public String model;

    @OneToMany(mappedBy = "model", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<Device> device = new HashSet<Device>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
