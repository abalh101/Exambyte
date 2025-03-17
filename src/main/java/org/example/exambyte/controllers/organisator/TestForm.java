package org.example.exambyte.controllers.organisator;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

public class TestForm {
    private @NotBlank(message = "Name darf nicht leer sein") String testName;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime startzeitpunkt;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime endzeitpunkt;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime ergebnisVeröffentlichungszeitpunkt;

    private @NotBlank(message = "Darf nicht leer sein") String fragestellung;
    private @Min(value = 0 , message = "darf nicht negativ sein") Integer maximalpunktzahl;

    // Getter und Setter
    public String getTestName() { return testName; }
    public void setTestName(String testName) { this.testName = testName; }

    public LocalDateTime getStartzeitpunkt() { return startzeitpunkt; }
    public void setStartzeitpunkt(LocalDateTime startzeitpunkt) { this.startzeitpunkt = startzeitpunkt; }

    public LocalDateTime getEndzeitpunkt() { return endzeitpunkt; }
    public void setEndzeitpunkt(LocalDateTime endzeitpunkt) { this.endzeitpunkt = endzeitpunkt; }

    public LocalDateTime getErgebnisVeröffentlichungszeitpunkt() { return ergebnisVeröffentlichungszeitpunkt; }
    public void setErgebnisVeröffentlichungszeitpunkt(LocalDateTime ergebnisVeröffentlichungszeitpunkt) {
        this.ergebnisVeröffentlichungszeitpunkt = ergebnisVeröffentlichungszeitpunkt;
    }

    public String getFragestellung() { return fragestellung; }
    public void setFragestellung(String fragestellung) { this.fragestellung = fragestellung; }

    public Integer getMaximalpunktzahl() { return maximalpunktzahl; }
    public void setMaximalpunktzahl(Integer maximalpunktzahl) { this.maximalpunktzahl = maximalpunktzahl; }
}
