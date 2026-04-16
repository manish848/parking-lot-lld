package com.parking.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public abstract class Vehicle {
    private String RegistrationNumber;
    private VehicleType type;

    public Vehicle(String RegistrationNumber, VehicleType type) {
        this.RegistrationNumber = RegistrationNumber;
        this.type = type;
    }

    public enum VehicleType {
        CAR, BIKE
    }
}