package com.parking.model;

import lombok.Getter;
import java.time.LocalDateTime;

@Getter
public class Ticket {
    private int id;
    private Vehicle vehicle;
    private ParkingSlot slot;
    private LocalDateTime entryTime;

    public Ticket(int id, Vehicle vehicle, ParkingSlot slot) {
        this.id = id;
        this.vehicle = vehicle;
        this.slot = slot;
        this.entryTime = LocalDateTime.now();
    }
}