package com.example.myTreasure.domain.devices;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="typeDevice")
public class TypeDevice {

    public TypeDevice(){}
    public TypeDevice(String type) {
        this.type = type;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String type;

    @OneToMany(mappedBy ="typeDevice", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<Device> device = new HashSet<Device>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
