package org.example.exambyte.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.example.exambyte.configuration.security.MethodSecurityConfiguration;
import org.example.exambyte.controllers.organisator.OrganisatorController;
import org.example.exambyte.helper.WithMockOAuth2User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(OrganisatorController.class)
@Import(MethodSecurityConfiguration.class)
public class OrganisatorControllerTest {


  @Autowired
  MockMvc mockMvc;

  @Test
  @DisplayName("landingpage für organisator ist fuer eingeloggte Organisator erreichbar")
  @WithMockOAuth2User(login = "something", roles = "ORGANISATOR")
  public void test_1() throws Exception {
    mockMvc.perform(get("/organisator"))
        .andExpect(status().isOk())
        .andExpect(view().name("organisator/landingpageorganisator"));
  }

  @Test
  @DisplayName("landingpage für organisator ist für andere Rollen nicht erreichbar")
  @WithMockOAuth2User(login = "something" , roles ={"KORREKTUR", "STUDENT"})
  public void test_2() throws Exception {
    mockMvc.perform(get("/organisator"))
        .andExpect(status().isForbidden());
  }

}
