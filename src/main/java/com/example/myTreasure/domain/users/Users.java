package com.example.myTreasure.domain.users;

import com.example.myTreasure.domain.dateDev.DateDevice;
import com.example.myTreasure.domain.devices.Device;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class Users {

    public Users (){}
    public Users(String name, String surname, String patronymic, Long numberOne, Long numberTwo, Long numberThree ,Device device) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.numberOne = numberOne;
        this.numberTwo = numberTwo;
        this.numberThree = numberThree;
        this.device=device;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    private String patronymic;
    private Long numberOne;
    private Long numberTwo;
    private Long numberThree;

    @ManyToOne
    @JoinColumn(name = "device_id", nullable = false)
    private Device device;

    @ManyToOne
    @JoinColumn(name = "dateDev_id", nullable = false)
    private DateDevice dateDevice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Long getNumberOne() {
        return numberOne;
    }

    public void setNumberOne(Long numberOne) {
        this.numberOne = numberOne;
    }

    public Long getNumberTwo() {
        return numberTwo;
    }

    public void setNumberTwo(Long numberTwo) {
        this.numberTwo = numberTwo;
    }

    public Long getNumberThree() {
        return numberThree;
    }

    public void setNumberThree(Long numberThree) {
        this.numberThree = numberThree;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }
}
