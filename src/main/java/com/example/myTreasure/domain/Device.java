package com.example.myTreasure.domain;


import javax.persistence.*;

@Entity
@Table(name = "device")
public class Device {

    public Device(){}
    public Device(String serial, Model model, Brand brand) {
        this.serial = serial;
        this.model = model;
        this.brand = brand;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public String serial;

    @ManyToOne
    @JoinColumn(name = "model_id", nullable = false)
    private Model model;

    @ManyToOne
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}
