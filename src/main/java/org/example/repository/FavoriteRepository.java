package org.example.repository;

import org.example.model.Favorite;
import org.example.model.User;
import org.example.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {

    List<Favorite> findByBuyer(User buyer);

    boolean existsByBuyerAndVehicle(User buyer, Vehicle vehicle);

    void deleteByBuyerAndVehicle(User buyer, Vehicle vehicle);

    Optional<Favorite> findByBuyerAndVehicle(User buyer, Vehicle vehicle);
}
