package org.example.repository;

import org.example.model.User;
import org.example.model.Vehicle;
import org.example.enums.VehicleStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    List<Vehicle> findByModelContainingIgnoreCase(String model);

    List<Vehicle> findByPriceBetween(double minPrice, double maxPrice);

    List<Vehicle> findByYear(int year);

    List<Vehicle> findBySeller(User seller);

    List<Vehicle> findByStatus(VehicleStatus status);
}
