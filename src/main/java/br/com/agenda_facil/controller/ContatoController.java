
package br.com.agenda_facil.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.agenda_facil.repository.ContatoRepository;

@Controller
public class ContatoController {

    private final ContatoRepository contatoRepository;

    public ContatoController(ContatoRepository contatoRepository) {
        this.contatoRepository = contatoRepository;
    }

    @GetMapping("/")
    public String listar(Model model) {

        model.addAttribute("contatos", contatoRepository.findAll());

        return "contatos";
    }

    @GetMapping("/contatos/novo")
    public String novo() {
        return "formulario";
    }

}
