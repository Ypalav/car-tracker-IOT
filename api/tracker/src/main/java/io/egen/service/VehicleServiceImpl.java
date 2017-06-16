package io.egen.service;

import io.egen.entity.Vehicle;
import io.egen.exception.NotFoundException;
import io.egen.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Yogesh on 6/12/2017.
 */
@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Transactional
    public void upsert(List<Vehicle> vehicleList) {
        for(Vehicle v:vehicleList) {
            Vehicle existingVehicle = vehicleRepository.findById(v.getVin());
            if (existingVehicle == null) {
                vehicleRepository.insert(v);
            }
            vehicleRepository.update(v);
        }
    }
}
