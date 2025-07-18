package org.example.dto;

import org.example.enums.VehicleStatus;

public class VehicleDTO {

    private Long id;
    private String model;
    private int year;
    private double price;
    private String description;
    private String imageUrl;
    private VehicleStatus status;
    private String sellerName;
    private String sellerEmail;

    public VehicleDTO() {
    }

    public VehicleDTO(Long id, String model, int year, double price,
                      String description, String imageUrl, VehicleStatus status,
                      String sellerName, String sellerEmail) {
        this.id = id;
        this.model = model;
        this.year = year;
        this.price = price;
        this.description = description;
        this.imageUrl = imageUrl;
        this.status = status;
        this.sellerName = sellerName;
        this.sellerEmail = sellerEmail;
    }

    public Long getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public VehicleStatus getStatus() {
        return status;
    }

    public String getSellerName() {
        return sellerName;
    }

    public String getSellerEmail() {
        return sellerEmail;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setStatus(VehicleStatus status) {
        this.status = status;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public void setSellerEmail(String sellerEmail) {
        this.sellerEmail = sellerEmail;
    }

    @Override
    public String toString() {
        return "VehicleDTO{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", status=" + status +
                ", sellerName='" + sellerName + '\'' +
                ", sellerEmail='" + sellerEmail + '\'' +
                '}';
    }
}
