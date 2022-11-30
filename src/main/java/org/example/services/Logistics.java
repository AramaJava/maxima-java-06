package org.example.services;


import org.example.model.City;
import org.example.model.transport.Transport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
  Модифицировать класс Logistics так,
          чтобы при отсутствии доступных транспортов фабрикой
          создавался бы новый транспорт.
*/

@Component
public class Logistics {

    private final Transport[] vehicles;
    private TransportFactory transportFactory;
    
    public Logistics(Transport... vehicles) {
        this.vehicles = vehicles;
    }

    @Autowired
    public Logistics(TransportFactory transportFactory, Transport... transports) {
        vehicles = transports;
        this.transportFactory = transportFactory;
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
        if (minCostTransport == null) {
            minCostTransport = transportFactory.getTransport(city, weight, hours);
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

