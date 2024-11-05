package org.example.exambyte;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MyController.class)
public class MyControllerTest {

    @Autowired
    MockMvc mockMvc;


    @Test
    @DisplayName("Indix-page is reachable")

    void test_1() throws Exception{
        mockMvc.perform(get("/index"))
                .andExpect(status().isOk());
    }
}
