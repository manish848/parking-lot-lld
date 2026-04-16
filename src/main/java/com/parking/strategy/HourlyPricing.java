package com.parking.strategy;

public class HourlyPricing implements PricingStrategy {
    public double calculateFee(long hours) {
        return hours * 20;
    }
}