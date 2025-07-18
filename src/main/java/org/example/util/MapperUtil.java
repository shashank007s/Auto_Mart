package org.example.util;

import org.example.dto.VehicleDTO;
import org.example.model.Vehicle;

public class MapperUtil {

    public static Vehicle toVehicleEntity(VehicleDTO dto) {
        Vehicle vehicle = new Vehicle();
        vehicle.setModel(dto.getModel());
        vehicle.setYear(dto.getYear());
        vehicle.setPrice(dto.getPrice());
        vehicle.setDescription(dto.getDescription());
        return vehicle;
    }

    public static VehicleDTO toVehicleDTO(Vehicle vehicle) {
        VehicleDTO dto = new VehicleDTO();
        dto.setId(vehicle.getId());
        dto.setModel(vehicle.getModel());
        dto.setYear(vehicle.getYear());
        dto.setPrice(vehicle.getPrice());
        dto.setDescription(vehicle.getDescription());
        return dto;
    }
}
