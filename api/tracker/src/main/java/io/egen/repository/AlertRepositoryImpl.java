package io.egen.repository;

import io.egen.entity.Alert;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Yogesh on 6/12/2017.
 */
@Repository
public class AlertRepositoryImpl implements AlertRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Alert createAlert(Alert alert) {
        entityManager.persist(alert);
        return alert;
    }
}
