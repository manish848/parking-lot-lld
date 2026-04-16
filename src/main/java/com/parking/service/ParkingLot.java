package com.parking.service;

import com.parking.model.*;
import com.parking.strategy.PricingStrategy;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

public class ParkingLot {

    private static ParkingLot instance;
    private List<ParkingSlot> slots = new ArrayList<>();
    private PricingStrategy pricingStrategy;

    private ParkingLot(int capacity, PricingStrategy strategy) {
        this.pricingStrategy = strategy;
        for (int i = 1; i <= capacity; i++) {
            slots.add(new ParkingSlot(i));
        }
    }

    public static ParkingLot getInstance(int capacity, PricingStrategy strategy) {
        if (instance == null) {
            instance = new ParkingLot(capacity, strategy);
        }
        return instance;
    }

    public Ticket park(Vehicle vehicle) {
        for (ParkingSlot slot : slots) {
            if (!slot.isOccupied()) {
                slot.park(vehicle);
                return new Ticket(new Random().nextInt(1000), vehicle, slot);
            }
        }
        throw new RuntimeException("Parking Full");
    }

    public double unpark(Ticket ticket) {
        ticket.getSlot().unpark();

        long hours = Duration.between(
                ticket.getEntryTime(),
                LocalDateTime.now()
        ).toHours();

        return pricingStrategy.calculateFee(hours);
    }
}