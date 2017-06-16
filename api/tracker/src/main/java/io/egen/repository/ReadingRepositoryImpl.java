package io.egen.repository;

import io.egen.entity.Reading;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Yogesh on 6/12/2017.
 */
@Repository
public class ReadingRepositoryImpl implements ReadingRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Reading createReading(Reading vehicleReading) {
        entityManager.persist(vehicleReading.getTire());
        entityManager.persist(vehicleReading);
        return vehicleReading;
    }
}
