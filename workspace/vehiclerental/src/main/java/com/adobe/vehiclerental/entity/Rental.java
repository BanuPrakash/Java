package com.adobe.vehiclerental.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="rentals")
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="rental_id")
    private int rentalId;

    @ManyToOne
    @JoinColumn(name="client_fk")
    private Client client;

    @ManyToOne
    @JoinColumn(name="vehicle_fk")
    private Vehicle vehicle;

    @Temporal(TemporalType.DATE)
    @Column(name="rent_from_date")
    private Date rentFromDate;

    @Column(name = "rent_to_date")
    private Date rentToDate;
}
