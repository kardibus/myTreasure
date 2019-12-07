package com.example.myTreasure.domain.dateDev;

import com.example.myTreasure.domain.users.Users;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "datedev")
public class DateDevice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDateTime dateOpen;
    private LocalDateTime dateClose;
    private LocalDateTime warranty;
    private Long numberDay;

    @OneToMany(mappedBy = "device", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<Users> users = new HashSet<Users>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateOpen() {
        return dateOpen;
    }

    public void setDateOpen(LocalDateTime dateOpen) {
        this.dateOpen = dateOpen;
    }

    public LocalDateTime getDateClose() {
        return dateClose;
    }

    public void setDateClose(LocalDateTime dateClose) {
        this.dateClose = dateClose;
    }

    public LocalDateTime getWarranty() {
        return warranty;
    }

    public void setWarranty(LocalDateTime warranty) {
        this.warranty = warranty;
    }

    public Long getNumberDay() {
        return numberDay;
    }

    public void setNumberDay(Long numberDay) {
        this.numberDay = numberDay;
    }

}
