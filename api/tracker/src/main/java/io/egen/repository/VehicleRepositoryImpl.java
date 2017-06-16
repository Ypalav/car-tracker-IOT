package io.egen.repository;

import io.egen.entity.Vehicle;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Yogesh on 6/12/2017.
 */
@Repository
public class VehicleRepositoryImpl implements VehicleRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void update(Vehicle vehicle) {
        entityManager.merge(vehicle);
    }

    @Override
    public void insert(Vehicle vehicle) {
        entityManager.persist(vehicle);
    }

    @Override
    public Vehicle findById(String vehicleId) {
        return entityManager.find(Vehicle.class, vehicleId);
    }
}
