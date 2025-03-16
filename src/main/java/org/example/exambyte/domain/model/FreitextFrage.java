package org.example.exambyte.domain.model;

import org.example.exambyte.annotations.AggregateEntity;

import java.util.UUID;

@AggregateEntity
public class FreitextFrage implements Frage {
    private final UUID id;
    private final String fragestellung;
    private final int maxPunkte;
    private final String loesungsvorschlag;

    public FreitextFrage(String fragestellung, int maxPunkte, String loesungsvorschlag) {
        this.id = UUID.randomUUID();
        this.fragestellung = fragestellung;
        this.maxPunkte = maxPunkte;
        this.loesungsvorschlag = loesungsvorschlag;
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

    public String getLoesungsvorschlag() {
        return loesungsvorschlag;
    }
}
