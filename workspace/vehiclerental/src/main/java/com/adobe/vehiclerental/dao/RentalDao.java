package com.adobe.vehiclerental.dao;

import com.adobe.vehiclerental.entity.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalDao extends JpaRepository<Rental, Integer> {
}
