package org.example.exambyte.controllers.organisator;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OrganisatorController {

    @GetMapping
    public String testErstellenForm(Model model) {
        model.addAttribute("testForm", new TestForm());
        return "organisator/testerstellung";
    }

    @PostMapping("/erstellen")
    public String testErstellen(@ModelAttribute @Valid TestForm testForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("testForm", testForm);
            return "organisator/fehler";
        }
        return "organisator/erfolgsseite";
    }

}
