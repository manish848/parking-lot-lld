package com.parking.strategy;

public interface PricingStrategy {
    double calculateFee(long hours);
}