package com.adobe.vehiclerental.service;

import com.adobe.vehiclerental.dao.ClientDao;
import com.adobe.vehiclerental.dao.RentalDao;
import com.adobe.vehiclerental.dao.VehicleDao;
import com.adobe.vehiclerental.entity.Client;
import com.adobe.vehiclerental.entity.Rental;
import com.adobe.vehiclerental.entity.Vehicle;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentalService {
    @Autowired
    private ClientDao clientDao;
    @Autowired
    private VehicleDao vehicleDao;
    @Autowired
    private RentalDao rentalDao;

    public  Rental getRental(int id) {
        return rentalDao.findById(id).get();
    }
    public long getVehicleCount() {
        return vehicleDao.count();
    }

    public long getClientCount() {
        return clientDao.count();
    }

    public Vehicle addVehicle(Vehicle v) {
        return  vehicleDao.save(v);
    }

    public Client addClient(Client c) {
        return clientDao.save(c);
    }

    public Rental rentVehicle(Rental r) {
        return  rentalDao.save(r); // INSERT
    }

    // here save() does update instead of new insert:because already the entity has PK
    public void returnVehicle(Rental rental) {
        rentalDao.save(rental); //update
    }
}
