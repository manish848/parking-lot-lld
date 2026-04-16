package com.parking;

import com.parking.factory.VehicleFactory;
import com.parking.model.Vehicle;
import com.parking.service.ParkingLot;
import com.parking.strategy.HourlyPricing;

public class Main {

    public static void main(String[] args) {

        // 1. Create Parking Lot (Singleton)
        ParkingLot parkingLot = ParkingLot.getInstance(5, new HourlyPricing());

        // 2. Create Vehicle using Factory
        Vehicle car = VehicleFactory.createVehicle(
                "KA01AB1234",
                Vehicle.VehicleType.CAR
        );

        // 3. Park Vehicle
        var ticket = parkingLot.park(car);
        System.out.println("Vehicle parked. Ticket ID: " + ticket.getId());

        // 4. Simulate delay (optional)
        try {
            Thread.sleep(2000); // 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 5. Unpark Vehicle
        double fee = parkingLot.unpark(ticket);
        System.out.println("Total Fee: " + fee);
    }
}