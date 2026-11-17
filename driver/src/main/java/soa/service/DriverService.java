package soa.service;



import org.springframework.stereotype.Service;

import soa.model.Driver;
import soa.repo.DriverRepo;

@Service
public class DriverService {

    DriverRepo DR;

    public DriverService(DriverRepo DR) {
        this.DR = DR;
    }

  
    public Driver addDriver(Driver driver) {
        return DR.save(driver);
    }



   
    public String deleteDriver(Long id) {

        if (DR.existsById(id)) {
            DR.deleteById(id);
            return "Driver deleted successfully";
        }

        return "Driver not found";
    }

 
    public Driver updateDriver(Long id, Driver driver) {

        Driver existingDriver = DR.findById(id).orElse(null);

        if (existingDriver != null) {

            existingDriver.setName(driver.getName());
            existingDriver.setRatings(driver.getRatings());

            return DR.save(existingDriver);
        }

        return null;
    }
}