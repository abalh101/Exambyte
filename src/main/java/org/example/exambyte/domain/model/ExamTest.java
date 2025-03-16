package org.example.exambyte.domain.model;


import org.example.exambyte.annotations.AggregateRoot;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AggregateRoot
public class ExamTest {

    private LocalDateTime startzeitpunkt;
    private LocalDateTime endzeitpunkt;
    private String name;
    private double maximalpunktzahl;
    private final UUID id;
    private final LocalDateTime ergebnisVeröffentlichungszeitpunkt;
    private final List<Frage> fragen;

    public ExamTest(LocalDateTime startpunkt, LocalDateTime endpunkt, String name, double maximalpunktzahl, UUID id, LocalDateTime ergebnisVeröffentlichungszeitpunkt, List<Frage> fragen) {
        this.startzeitpunkt = startpunkt;
        this.endzeitpunkt = endpunkt;
        this.name = name;
        this.maximalpunktzahl = maximalpunktzahl;
        this.id = id;
        this.ergebnisVeröffentlichungszeitpunkt = ergebnisVeröffentlichungszeitpunkt;
        this.fragen = fragen;
    }

    public LocalDateTime getStartzeitpunkt() {
        return startzeitpunkt;
    }

    public LocalDateTime getEndzeitpunkt() {
        return endzeitpunkt;
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

    public LocalDateTime getErgebnisVeröffentlichungszeitpunkt() {
        return ergebnisVeröffentlichungszeitpunkt;
    }

    public List<Frage> getFragen() {
        return new ArrayList<>(fragen);
    }
    public void addFrage(Frage frage) {
        this.fragen.add(frage);
    }

    public boolean isAktiv() {
        LocalDateTime now = LocalDateTime.now();
        return now.isAfter(startzeitpunkt) && now.isBefore(endzeitpunkt);
    }

    public boolean isAbgeschlossen() {
        return LocalDateTime.now().isAfter(endzeitpunkt);
    }

}
