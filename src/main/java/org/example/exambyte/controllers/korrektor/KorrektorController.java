package org.example.exambyte.controllers.korrektor;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/korrektor")
public class KorrektorController {

  @GetMapping("")
  public String landingpageFuerKorrektor(Model model, @AuthenticationPrincipal OAuth2User principal) {

    model.addAttribute(principal != null ? principal.getAttribute("login") : null);

    return "korrektor/landingpagekorrektor";
  }

}
