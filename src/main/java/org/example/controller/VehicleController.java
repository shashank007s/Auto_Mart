package org.example.controller;

import org.example.model.Vehicle;
import org.example.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/vehicleController")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping
    public ResponseEntity<List<Vehicle>> getAllAvailableVehicles() {
        return ResponseEntity.ok(vehicleService.getAllAvailableVehicles());
    }

    @GetMapping("/search")
    public ResponseEntity<List<Vehicle>> searchByModel(@RequestParam String model) {
        return ResponseEntity.ok(vehicleService.searchByModel(model));
    }

    @GetMapping("/filter/price")
    public ResponseEntity<List<Vehicle>> filterByPrice(
            @RequestParam double min,
            @RequestParam double max) {
        return ResponseEntity.ok(vehicleService.filterByPrice(min, max));
    }

    @GetMapping("/filter/year")
    public ResponseEntity<List<Vehicle>> filterByYear(@RequestParam int year) {
        List<Vehicle> vehicles = vehicleService.getAllAvailableVehicles().stream()
                .filter(v -> v.getYear() == year)
                .collect(Collectors.toList());
        return ResponseEntity.ok(vehicles);
    }

    @PostMapping
    public ResponseEntity<String> addVehicle(@RequestBody Vehicle vehicle) {
        vehicleService.saveVehicle(vehicle); // Ensure implementation in service
        return ResponseEntity.ok("Vehicle saved successfully");

    }
}
