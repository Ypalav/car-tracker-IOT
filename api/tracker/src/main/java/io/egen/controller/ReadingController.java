package io.egen.controller;

import io.egen.entity.Reading;
import io.egen.entity.Vehicle;
import io.egen.service.ReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Yogesh on 6/12/2017.
 */
@CrossOrigin(origins = "http://mocker.egen.io", maxAge = 3600)
@RestController
@RequestMapping(value = "readings")
public class ReadingController {
    @Autowired
    private ReadingService readingService;

    @RequestMapping(method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Reading createReading(@RequestBody Reading vehicleReading){
        return readingService.update(vehicleReading);
    }
}
