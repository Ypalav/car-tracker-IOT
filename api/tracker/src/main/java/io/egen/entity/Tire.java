package io.egen.entity;

import javax.persistence.*;
import java.util.UUID;

/**
 * Created by Yogesh on 6/14/2017.
 */
@Entity
public class Tire {

    @Id
    @Column(columnDefinition = "varchar(36)")
    private String tireId;
    private double frontLeft;
    private double frontRight;
    private double rearLeft;
    private double rearRight;

    public Tire(){
        this.tireId = UUID.randomUUID().toString();
    }

    public String getTireId() {
        return tireId;
    }

    public void setTireId(String tireId) {
        this.tireId = tireId;
    }

    public double getFrontLeft() {
        return frontLeft;
    }

    public void setFrontLeft(double frontLeft) {
        this.frontLeft = frontLeft;
    }

    public double getFrontRight() {
        return frontRight;
    }

    public void setFrontRight(double frontRight) {
        this.frontRight = frontRight;
    }

    public double getRearLeft() {
        return rearLeft;
    }

    public void setRearLeft(double rearLeft) {
        this.rearLeft = rearLeft;
    }

    public double getRearRight() {
        return rearRight;
    }

    public void setRearRight(double rearRight) {
        this.rearRight = rearRight;
    }

}
