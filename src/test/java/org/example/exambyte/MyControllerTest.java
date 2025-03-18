package org.example.exambyte;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class MyControllerTest {

    @Autowired
    MockMvc mockMvc;


    @Test
    @DisplayName("indix-page is reachable")
    void test_1() throws Exception{
        mockMvc.perform(get("/index"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("admin-page ist reachable")
    void test_admin_page() throws Exception{
        mockMvc.perform(get("/admin"))
                .andExpect(status().isOk());
    }
    @Test
    @DisplayName("student-page is reachable")
        void test_student_page() throws Exception {
        mockMvc.perform(get("/student"))
                .andExpect(status().isOk());
    }
    @Test
    @DisplayName("organisator-page is reachable")
    void test_organisator_page() throws Exception {
        mockMvc.perform(get("/organisator"))
                .andExpect(status().isOk());
    }
    @Test
    @DisplayName("corrector-page is reachable")
    void test_corrector_page() throws Exception {
        mockMvc.perform(get("/corrector"))
                .andExpect(status().isOk());
    }
    @Test
    @DisplayName("index_page redirect to student,correcotr,organisator and admin")
    void testRedirects() throws Exception {
        String[] urls = {"/student", "/corrector", "/organisator", "/admin"};

        for (String url : urls) {
            mockMvc.perform(get(url))
                    .andExpect(status().isOk()); // all tests together
        }
    }
}
