package com.parking.model;
import lombok.Getter;
import lombok.AllArgsConstructor;

@Getter
public class Car extends Vehicle {
    public Car(String RegistrationNumber)
    {
        super(RegistrationNumber, VehicleType.CAR);
    }

}
