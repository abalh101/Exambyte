package org.example.exambyte.domain.model;

import org.example.exambyte.annotations.AggregateEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AggregateEntity
public class MultipleChoiceFrage implements Frage {

    private final UUID id;
    private final String fragestellung;
    private final int maxPunkte;
    private final List<String> antwortMoeglichkeiten;
    private final List<Integer> korrekteAntworten;
    private final String erklaerung;

    public MultipleChoiceFrage(String fragestellung, int maxPunkte, List<String> antwortMoeglichkeiten, List<Integer> korrekteAntworten, String erklaerung) {
        this.id = UUID.randomUUID();
        this.fragestellung = fragestellung;
        this.maxPunkte = maxPunkte;
        this.antwortMoeglichkeiten = new ArrayList<>(antwortMoeglichkeiten);
        this.korrekteAntworten = new ArrayList<>(korrekteAntworten);
        this.erklaerung = erklaerung;
    }
    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public String getFragestellung() {
        return fragestellung;
    }

    @Override
    public int getMaxPunkte() {
        return maxPunkte;
    }

    public List<String> getAntwortMoeglichkeiten() {
        return new ArrayList<>(antwortMoeglichkeiten);
    }

    public List<Integer> getKorrekteAntworten() {
        return new ArrayList<>(korrekteAntworten);
    }

    public String getErklaerung() {
        return erklaerung;
    }
}
