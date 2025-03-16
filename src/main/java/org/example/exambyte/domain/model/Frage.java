package org.example.exambyte.domain.model;

import java.util.UUID;

public interface Frage {

    UUID getId();
    String getFragestellung();
    int getMaxPunkte();
}
