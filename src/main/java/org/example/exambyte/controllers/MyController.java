package org.example.exambyte.controllers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

    @GetMapping("/")
    public String index() {

        return "index";
    }

    @Secured({"ROLE_STUDENT", "ROLE_ORGANISATOR", "ROLE_KORREKTOR"})
    @GetMapping("/redirect")
    public String redirectBasedOnRole (@AuthenticationPrincipal OAuth2User principal) {
        if(principal.getAuthorities().stream().anyMatch(a->a.getAuthority().equals("ROLE_STUDENT"))) {
            return "redirect:/student";
        }
        if(principal.getAuthorities().stream().anyMatch(a->a.getAuthority().equals("ROLE_ORGANISATOR"))) {
            return "redirect:/organisator";
        }
        if(principal.getAuthorities().stream().anyMatch(a->a.getAuthority().equals("ROLE_KORREKTOR"))) {
            return "redirect:/korrektor";
        }
        return "redirect:/";
    }

   /* @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @GetMapping("/student")
    public String student() {
        return "student";
    }
    @GetMapping("corrector")
    public String corrector() {
        return "corrector";
    }

    @GetMapping("/organisator")
    public String organisator() {
        return "organisator/organisator"; // Korrekte Pfadangabe
    }
*/

}


