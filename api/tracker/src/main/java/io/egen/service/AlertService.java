package io.egen.service;

import io.egen.entity.Alert;
import io.egen.entity.Reading;
import io.egen.entity.Vehicle;

import java.util.List;

/**
 * Created by Yogesh on 6/12/2017.
 */
public interface AlertService {
    void createAlert(List<Alert> alerts);
}
