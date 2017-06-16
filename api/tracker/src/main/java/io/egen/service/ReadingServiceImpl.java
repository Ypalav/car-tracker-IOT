package io.egen.service;

import io.egen.entity.Alert;
import io.egen.entity.Reading;
import io.egen.entity.Vehicle;
import io.egen.exception.NotFoundException;
import io.egen.repository.AlertRepository;
import io.egen.repository.ReadingRepository;
import io.egen.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Yogesh on 6/12/2017.
 */
@Service
public class ReadingServiceImpl implements ReadingService {

    @Autowired
    private ReadingRepository readingRepository;
    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private AlertServiceImpl alertService;

    @Transactional
    public Reading update(Reading vehicleReading) {
        Vehicle existingVehicle = vehicleRepository.findById(vehicleReading.getVin());
        if(existingVehicle==null)
            throw new NotFoundException("Vehicle with id= "+vehicleReading.getVin()+" not found");
        List<Alert> alerts = getAlerts(vehicleReading, existingVehicle);
        alertService.createAlert(alerts);
        return readingRepository.createReading(vehicleReading);
    }

    private List<Alert> getAlerts(Reading vehicleReading, Vehicle existingVehicle) {
        List<Alert> alertsList = new ArrayList<Alert>();

        if(vehicleReading.getEngineRpm()>existingVehicle.getRedlineRpm()) {
            Alert newAlert = new Alert();
            newAlert.setVin(vehicleReading.getVin());
            newAlert.setTimestamp(Calendar.getInstance().getTime());
            newAlert.setMessage("High Engine Rpm");
            newAlert.setPriority("HIGH");
            alertsList.add(newAlert);
        }

        if(vehicleReading.getFuelVolume()< (0.1*existingVehicle.getMaxFuelVolume())) {
            Alert newAlert = new Alert();
            newAlert.setVin(vehicleReading.getVin());
            newAlert.setTimestamp(Calendar.getInstance().getTime());
            newAlert.setMessage("Fuel Volume is reduced ");
            newAlert.setPriority("MEDIUM");
            alertsList.add(newAlert);
        }

        if(vehicleReading.getTire().getFrontLeft()<32 || vehicleReading.getTire().getFrontLeft()>36) {
            Alert newAlert = new Alert();
            newAlert.setVin(vehicleReading.getVin());
            newAlert.setTimestamp(Calendar.getInstance().getTime());
            newAlert.setMessage("Front left tire pressure is low");
            newAlert.setPriority("LOW");
            alertsList.add(newAlert);
        }

        if(vehicleReading.getTire().getFrontRight()<32 || vehicleReading.getTire().getFrontRight()>36) {
            Alert newAlert = new Alert();
            newAlert.setVin(vehicleReading.getVin());
            newAlert.setTimestamp(Calendar.getInstance().getTime());
            newAlert.setMessage("Front right tire pressure is low");
            newAlert.setPriority("LOW");
            alertsList.add(newAlert);
        }

        if(vehicleReading.getTire().getRearLeft()<32 || vehicleReading.getTire().getRearLeft()>36) {
            Alert newAlert = new Alert();
            newAlert.setVin(vehicleReading.getVin());
            newAlert.setTimestamp(Calendar.getInstance().getTime());
            newAlert.setMessage("Rear left tire pressure is low");
            newAlert.setPriority("LOW");
            alertsList.add(newAlert);
        }

        if(vehicleReading.getTire().getRearRight()<32 || vehicleReading.getTire().getRearRight()>36) {
            Alert newAlert = new Alert();
            newAlert.setVin(vehicleReading.getVin());
            newAlert.setTimestamp(Calendar.getInstance().getTime());
            newAlert.setMessage("Rear right tire pressure is low");
            newAlert.setPriority("LOW");
            alertsList.add(newAlert);
        }

        if(vehicleReading.isCheckEngineLightOn()||vehicleReading.isEngineCoolantLow()) {
            Alert newAlert = new Alert();
            newAlert.setVin(vehicleReading.getVin());
            newAlert.setTimestamp(Calendar.getInstance().getTime());
            if(vehicleReading.isCheckEngineLightOn()) {
                newAlert.setMessage("Engine light is on");
            } else  {
                newAlert.setMessage("Engine coolant is low");
            }
            newAlert.setPriority("LOW");
            alertsList.add(newAlert);
        }
        return alertsList;
    }
}
