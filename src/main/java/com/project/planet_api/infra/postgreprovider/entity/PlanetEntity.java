package com.project.planet_api.infra.postgreprovider.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "planet")
public class PlanetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double aphelion;
    private double density;
    private double diameter;
    private double distanceFromSun;
    private double escapeVelocity;
    private boolean globalMagneticField;
    private double gravity;
    private double lengthOfDay;
    private double mass;
    private double meanTemperature;
    private String name;
    private double numberOfMoons;
    private double obliquityToOrbit;
    private double orbitalEccentricity;
    private double orbitalInclination;
    private double orbitalPeriod;
    private double orbitalVelocity;
    private double perihelion;
    private boolean ringSystem;
    private double rotationPeriod;
    private double surfacePressure;
}
