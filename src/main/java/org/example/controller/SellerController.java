package org.example.controller;

import org.example.model.User;
import org.example.model.Vehicle;
import org.example.service.UserService;
import org.example.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seller")
public class SellerController {

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private UserService userService;


    @PostMapping("/vehicles")
    public ResponseEntity<String> postVehicle(@RequestBody Vehicle vehicle, Authentication auth) {
        User seller = userService.getByEmail(auth.getName());
        vehicleService.postVehicle(vehicle, seller);
        return ResponseEntity.ok("Vehicle posted successfully.");
    }

    @GetMapping("/vehicles")
    public ResponseEntity<List<Vehicle>> getSellerVehicles(Authentication auth) {
        User seller = userService.getByEmail(auth.getName());
        List<Vehicle> vehicles = vehicleService.getVehiclesBySeller(seller);
        return ResponseEntity.ok(vehicles);
    }

    @PutMapping("/{vehicleId}/sold")
    public ResponseEntity<String> markAsSold(@PathVariable("vehicleId") Long vehicleId, Authentication auth) {
        User seller = userService.getByEmail(auth.getName());
        Vehicle vehicle = vehicleService.markAsSold(vehicleId);

        if (!vehicle.getSeller().getId().equals(seller.getId())) {
            return ResponseEntity.status(403).body("You are not authorized to update this vehicle.");
        }

        return ResponseEntity.ok("Vehicle marked as sold.");
    }
}
