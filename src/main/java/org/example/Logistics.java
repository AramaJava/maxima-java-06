package org.example;

import org.springframework.stereotype.Component;

@Component
public class Logistics {

    private final Transport[] vehicles;

    public Logistics(Transport... vehicles) {
        this.vehicles = vehicles;
    }


    public Transport getShipping(City city, int weight, int hours) {
        Transport minCostTransport = null;
        for (Transport vehicle : vehicles) {
            if (isShippingAvailable(city, vehicle, weight, hours)) {
                if (minCostTransport == null) {
                    minCostTransport = vehicle;
                } else if (vehicle.getCostOfKm() < minCostTransport.getCostOfKm()) {
                    minCostTransport = vehicle;
                }
            }
        }
        return minCostTransport;
    }


    private boolean isShippingAvailable(City city, Transport vehicles, int weight, int hours) {
        return !vehicles.isRepairing()
                && vehicles.getCapacity() >= weight
                && (float) city.getDistanceKm() / vehicles.getSpeed() <= (float) hours
                && vehicles.getPrice(city) != 0f;
    }

}

