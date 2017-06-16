package io.egen.repository;

import io.egen.entity.Vehicle;

/**
 * Created by Yogesh on 6/12/2017.
 */
public interface VehicleRepository {

    void update(Vehicle vehicle);

    void insert(Vehicle vehicle);

    Vehicle findById(String vehicleId);
}
