package org.example.exambyte.persestince;

import org.example.exambyte.domain.model.Frage;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record ExamTestDTO(
        @Id UUID id,
        String name,
        double maximalpunktzahl,
        LocalDateTime startzeitpunkt,
        LocalDateTime endzeitpunkt,
        LocalDateTime ergebnisVeröffentlichungszeitpunkt,
        List<Frage> fragen
) {
}