package com.example.myTreasure.domain.devices;

import com.example.myTreasure.domain.registration.UserAuth;
import com.example.myTreasure.domain.users.Users;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "device")
public class Device {

    public Device(){}
    public Device(String serial, Model model, Brand brand ,TypeDevice typeDevice) {
        this.serial = serial;
        this.model = model;
        this.brand = brand;
        this.typeDevice=typeDevice;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String serial;

    @ManyToOne
    @JoinColumn(name = "type_device_id", nullable = false)
    private TypeDevice typeDevice;

    @ManyToOne
    @JoinColumn(name = "model_id", nullable = false)
    private Model model;

    @ManyToOne
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_auth_id")
    private UserAuth userAuth;

    @OneToMany(mappedBy = "device", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<Users> users = new HashSet<Users>();

    private String getAuthorName(){
        return userAuth != null ? userAuth.getUsername() : "<none>";
    }

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

    public UserAuth getUserAuth() {
        return userAuth;
    }

    public void setUserAuth(UserAuth userAuth) {
        this.userAuth = userAuth;
    }

    public TypeDevice getTypeDevice() {
        return typeDevice;
    }

    public void setTypeDevice(TypeDevice typeDevice) {
        this.typeDevice = typeDevice;
    }
}
