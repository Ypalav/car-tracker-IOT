package io.egen.service;

import io.egen.entity.Vehicle;

import java.util.List;

/**
 * Created by Yogesh on 6/12/2017.
 */
public interface VehicleService {

    void upsert(List<Vehicle> vehicle);
}
