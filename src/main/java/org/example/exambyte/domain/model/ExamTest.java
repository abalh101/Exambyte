package org.example.exambyte.domain.model;


import org.example.exambyte.annotations.AggregateRoot;

import java.time.LocalDateTime;
import java.util.UUID;

@AggregateRoot
public class ExamTest {

    private LocalDateTime startpunkt;
    private LocalDateTime endpunkt;
    private String name;
    private double maximalpunktzahl;
    private final UUID id;

    public ExamTest(LocalDateTime startpunkt, LocalDateTime endpunkt, String name, double maximalpunktzahl, UUID id) {
        this.startpunkt = startpunkt;
        this.endpunkt = endpunkt;
        this.name = name;
        this.maximalpunktzahl = maximalpunktzahl;
        this.id = id;
    }

    public LocalDateTime getStartpunkt() {
        return startpunkt;
    }

    public LocalDateTime getEndpunkt() {
        return endpunkt;
    }

    public String getName() {
        return name;
    }

    public double getMaximalpunktzahl() {
        return maximalpunktzahl;
    }

    public UUID getId() {
        return id;
    }

    public void setStartpunkt(LocalDateTime startpunkt) {
        this.startpunkt = startpunkt;
    }

    public void setEndpunkt(LocalDateTime endpunkt) {
        this.endpunkt = endpunkt;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMaximalpunktzahl(double maximalpunktzahl) {
        this.maximalpunktzahl = maximalpunktzahl;
    }
}
