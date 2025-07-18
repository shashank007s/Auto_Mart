package org.example.service;

import org.example.model.Favorite;
import org.example.model.User;
import org.example.model.Vehicle;
import org.example.repository.FavoriteRepository;
import org.example.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteService {

    @Autowired
    private FavoriteRepository favoriteRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    public Favorite addFavorite(User buyer, Long vehicleId) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));

        if (favoriteRepository.existsByBuyerAndVehicle(buyer, vehicle)) {
            throw new RuntimeException("Already favorited");
        }

        return favoriteRepository.save(new Favorite(null, buyer, vehicle));
    }

    public List<Favorite> getFavorites(User buyer) {
        return favoriteRepository.findByBuyer(buyer);
    }

    public void removeFavorite(User buyer, Long vehicleId) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));

        favoriteRepository.deleteByBuyerAndVehicle(buyer, vehicle);
    }
}
