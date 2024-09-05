package com.adobe.vehiclerental.client;

import com.adobe.vehiclerental.entity.Client;
import com.adobe.vehiclerental.entity.Rental;
import com.adobe.vehiclerental.entity.Vehicle;
import com.adobe.vehiclerental.service.RentalService;
import com.adobe.vehiclerental.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class RentalClient implements CommandLineRunner {
    @Autowired
    private RentalService rentalService;

    @Override
    public void run(String... args) throws Exception {
//        addVehicles();
//        addClients();
//        rentVehicle();
        returnVehicle();
    }

    private void returnVehicle() {
        Rental rental = rentalService.getRental(1); // existing rental
        rental.setRentToDate(DateUtil.toDate("5-09-2024")); //returning date
        rentalService.returnVehicle(rental);
    }

    private void rentVehicle() {
        Rental rental = Rental.builder().
        client(Client.builder().email("jill@gmail.com").build()).
                vehicle(Vehicle.builder().regNo("KA12E1234").build()).
                rentFromDate(DateUtil.toDate("3-09-2024"))
        .build();

        rentalService.rentVehicle(rental); // rent a Vehicle
    }

    private void addClients() {
        if(rentalService.getClientCount() == 0) {
            rentalService.addClient(Client.builder().email("jack@gmail.com").firstName("Jack").build());
            rentalService.addClient(Client.builder().email("jill@gmail.com").firstName("Jill").build());
        }
    }

    private void addVehicles() {
        if(rentalService.getVehicleCount() == 0) {
            rentalService.addVehicle(Vehicle.builder().
                    regNo("KA12E1234").
                    fuelType("PETROL").
                    costPerDay(5400).build());
            rentalService.addVehicle(Vehicle.builder().
                    regNo("UP50AE877").
                    fuelType("DIESEL").
                    costPerDay(8400).build());
        }
    }
}
