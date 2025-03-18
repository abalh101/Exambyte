package org.example.exambyte.testOrganisator;

import org.example.exambyte.controllers.organisator.TestForm;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.instanceOf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
public class testOrganisator {

    @Autowired
    MockMvc mvc;


    @Test
    @DisplayName("TestErstellungForm ist aufrufbar")

    void testErstellungForm() throws Exception {
        mvc.perform(get("/"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Im Model steht new TestForm")
    void testModel() throws Exception {
        mvc.perform(get("/"))
                .andExpect(model().attribute("testForm" , instanceOf(TestForm.class)));
    }

    @Test
    @DisplayName("ViewName ist 'organisator/testerstellung'")
    void testViewName() throws Exception {
        mvc.perform(get("/"))
                .andExpect(view().name("organisator/testerstellung"));
    }
    @Test
    @DisplayName("testErstellen ist aufrufbar")
    void testErstellen() throws Exception {
        mvc.perform(post("/erstellen"))
                .andExpect(status().is(200));
    }


    @Test
    @DisplayName("Bei Validierungsfehlern bleibt der Nutzer auf der Fehlerseite")
    void testErstellenViewName_Fehler() throws Exception {
        mvc.perform(post("/erstellen")
                        .param("testName", "")  // Name darf nicht leer sein -> Fehler
                        .param("startzeitpunkt", "")
                        .param("endzeitpunkt", "")
                        .param("ergebnisVeröffentlichungszeitpunkt", "")
                        .param("fragestellung", "")
                        .param("maximalpunktzahl", "-1")) // Darf nicht negativ sein -> Fehler
                .andExpect(model().attributeExists("testForm")) // Das fehlerhafte Objekt wird zurückgegeben
                .andExpect(view().name("organisator/fehler"));
    }


}
