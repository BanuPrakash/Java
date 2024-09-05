package com.adobe.vehiclerental.dao;

import com.adobe.vehiclerental.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleDao extends JpaRepository<Vehicle, String> {
}
