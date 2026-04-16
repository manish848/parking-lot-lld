package com.parking.factory;

import com.parking.model.*;

public class VehicleFactory {

    public static Vehicle createVehicle(String number, Vehicle.VehicleType type) {
        switch (type) {
            case CAR:
                return new Car(number);
            case BIKE:
                return new Bike(number);
            default:
                throw new IllegalArgumentException("Invalid type");
        }
    }
}
