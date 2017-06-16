package io.egen.controller;

import io.egen.entity.Vehicle;
import io.egen.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;
/**
 * Created by Yogesh on 6/12/2017.
 */
@CrossOrigin(origins = "http://mocker.egen.io", maxAge = 3600)
@RestController
@RequestMapping(value = "vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void upsert(@RequestBody List<Vehicle> vehicle){
        vehicleService.upsert(vehicle);
    }

}
