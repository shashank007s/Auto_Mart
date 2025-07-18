package org.example.service;

import org.example.enums.VehicleStatus;
import org.example.model.User;
import org.example.model.Vehicle;
import org.example.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    public void postVehicle(Vehicle vehicle, User seller) {
        vehicle.setSeller(seller);
        vehicle.setStatus(VehicleStatus.AVAILABLE);
        vehicleRepository.save(vehicle);
    }

    public List<Vehicle> getAllAvailableVehicles() {
        return vehicleRepository.findByStatus(VehicleStatus.AVAILABLE);
    }

    public List<Vehicle> searchByModel(String model) {
        return vehicleRepository.findByModelContainingIgnoreCase(model);
    }

    public List<Vehicle> filterByPrice(double min, double max) {
        return vehicleRepository.findByPriceBetween(min, max);
    }

    public List<Vehicle> getVehiclesBySeller(User seller) {
        return vehicleRepository.findBySeller(seller);
    }

    public Vehicle markAsSold(Long id) {
        Vehicle v = vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));
        v.setStatus(VehicleStatus.SOLD);
        return vehicleRepository.save(v);
    }

    public void saveVehicle(Vehicle vehicle) {

    }
}
