package com.example.myTreasure.repository.device;

import com.example.myTreasure.domain.devices.TypeDevice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeDeviceRepo extends JpaRepository<TypeDevice,Long> {
    Iterable<TypeDevice> findByTypeLike(String s);
}
