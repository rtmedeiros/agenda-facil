
package br.com.agenda_facil.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // Página inicial do Agenda Fácil
    @GetMapping("/")
    public String inicio() {

        // Redireciona para a lista de contatos
        return "redirect:/contatos";
    }

}
