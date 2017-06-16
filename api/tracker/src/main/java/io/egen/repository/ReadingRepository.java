package io.egen.repository;

import io.egen.entity.Reading;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Yogesh on 6/12/2017.
 */
public interface ReadingRepository {
    Reading createReading(Reading vehicleReading);
}
