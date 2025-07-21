package org.example.controller;

import org.example.model.Favorite;
import org.example.model.User;
import org.example.model.Vehicle;
import org.example.service.FavoriteService;
import org.example.service.UserService;
import org.example.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/buyer")
public class BuyerController {

    @Autowired
    private FavoriteService favoriteService;

    @Autowired
    private UserService userService;

    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/vehicles")
    public ResponseEntity<List<Vehicle>> getAllSellerVehicles() {
        List<Vehicle> vehicles = vehicleService.getAllVehicles();
        return ResponseEntity.ok(vehicles);
    }

    @PostMapping("/favorites/{vehicleId}")
    public ResponseEntity<String> addFavorite(@PathVariable("vehicleId") Long vehicleId, Authentication auth) {
        User buyer = userService.getByEmail(auth.getName());

        if (buyer == null) {
            return ResponseEntity.badRequest().body("User not found.");
        }

        favoriteService.addFavorite(buyer, vehicleId);
        return ResponseEntity.ok("Vehicle added to favorites.");
    }

    @GetMapping("/favorites")
    public ResponseEntity<List<Favorite>> getFavorites(Authentication auth) {
        User buyer = userService.getByEmail(auth.getName());
        List<Favorite> favorites = favoriteService.getFavorites(buyer);
        return ResponseEntity.ok(favorites);
    }

    @DeleteMapping("/favorites/{vehicleId}")
    public ResponseEntity<String> removeFavorite(@PathVariable("vehicleId") Long vehicleId, Authentication auth) {
        User buyer = userService.getByEmail(auth.getName());
        favoriteService.removeFavorite(buyer, vehicleId);
        return ResponseEntity.ok("Removed from favorites.");
    }
}
