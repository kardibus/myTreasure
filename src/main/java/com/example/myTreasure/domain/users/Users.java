package com.example.myTreasure.domain.users;

import com.example.myTreasure.domain.devices.Device;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class Users {
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
}
