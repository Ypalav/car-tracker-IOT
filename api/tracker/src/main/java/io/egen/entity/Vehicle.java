package io.egen.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import java.util.UUID;

/**
 * Created by Yogesh on 6/12/2017.
 */
@Entity
public class Vehicle {
    @Id
    @Column(columnDefinition = "varchar(36)")
    private String vin;
    private String make;
    private String model;
    private int year;
    private int redlineRpm;
    private int maxFuelVolume;
    private String lastServiceDate;

    public Vehicle(){
        this.vin = UUID.randomUUID().toString();
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getRedlineRpm() {
        return redlineRpm;
    }

    public void setRedlineRpm(int redlineRpm) {
        this.redlineRpm = redlineRpm;
    }

    public int getMaxFuelVolume() {
        return maxFuelVolume;
    }

    public void setMaxFuelVolume(int maxFuelVolume) {
        this.maxFuelVolume = maxFuelVolume;
    }

    public String getLastServiceDate() {
        return lastServiceDate;
    }

    public void setLastServiceDate(String lastServiceDate) {
        this.lastServiceDate = lastServiceDate;
    }




    /*@Override
    public String toString(){
       *//* return "Vehicle{" +
                "vin"*//*

    }*/

}
