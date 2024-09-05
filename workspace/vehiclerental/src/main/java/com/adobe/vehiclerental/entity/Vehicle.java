package com.adobe.vehiclerental.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="vehicles")
public class Vehicle {
    @Id
    @Column(name="REG_NO")
    private  String regNo;

    @Column(name="fuel_type")
    private String fuelType;

    @Column(name="cost_per_day")
    private double costPerDay;
}
