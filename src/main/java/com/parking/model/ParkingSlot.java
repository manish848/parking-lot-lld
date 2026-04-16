package com.parking.model;

import lombok.Getter;
import lombok.AllArgsConstructor;

@Getter
@AllArgsConstructor
public class ParkingSlot {
    int slotNumber;
    Vehicle vehicle;
    boolean isOccupied;

    public void park(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.isOccupied = true;
    }

    public void unpark() {
        this.vehicle = null;
        this.isOccupied = false;
    }

    public ParkingSlot(int slotNumber) {
        this.slotNumber = slotNumber;
        this.isOccupied = false;
    }

}
