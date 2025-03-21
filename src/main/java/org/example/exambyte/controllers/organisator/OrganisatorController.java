package org.example.exambyte.controllers.organisator;

import jakarta.validation.Valid;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OrganisatorController {

  @Secured("ROLE_ORGANISATOR")
  @GetMapping("/organisator")
  public String landingpageFuerOrganisator(Model model,
      @AuthenticationPrincipal OAuth2User principal) {

    model.addAttribute(principal != null ? principal.getAttribute("login") : null);

    return "organisator/landingpageorganisator";
  }

  @Secured("ROLE_ORGANISATOR")
  @GetMapping("/organisator/erstellen")
  public String testErstellenForm(Model model) {
    model.addAttribute("testForm", new TestForm());
    return "organisator/testerstellung";
  }

  @Secured("ROLE_ORGANISATOR")
  @PostMapping("/organisator/erstellen")
  public String testErstellen(@ModelAttribute @Valid TestForm testForm, BindingResult bindingResult,
      Model model) {
    if (bindingResult.hasErrors()) {
      model.addAttribute("testForm", testForm);
      return "organisator/fehler";
    }
    return "organisator/erfolgsseite";
  }

}
