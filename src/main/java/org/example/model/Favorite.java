package org.example.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

@Table(name = "favorites", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"buyer_id", "vehicle_id"})
})
public class Favorite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "buyer_id", nullable = false)
    private User buyer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;

    public Favorite() {
    }

    public Favorite(Long id, User buyer, Vehicle vehicle) {
        this.id = id;
        this.buyer = buyer;
        this.vehicle = vehicle;
    }

    public Favorite(User buyer, Vehicle vehicle) {
        this.buyer = buyer;
        this.vehicle = vehicle;
    }

    public Long getId() {
        return id;
    }

    public User getBuyer() {
        return buyer;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        return "Favorite{" +
                "id=" + id +
                ", buyerId=" + (buyer != null ? buyer.getId() : null) +
                ", vehicleId=" + (vehicle != null ? vehicle.getId() : null) +
                '}';
    }
}
