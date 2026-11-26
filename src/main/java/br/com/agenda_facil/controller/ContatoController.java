
package br.com.agenda_facil.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.agenda_facil.model.Contato;
import br.com.agenda_facil.repository.ContatoRepository;

import jakarta.validation.Valid;

@Controller
public class ContatoController {

    // Repositório responsável pelo acesso ao banco de dados
    private final ContatoRepository contatoRepository;

    // Injeção de dependência pelo construtor
    public ContatoController(ContatoRepository contatoRepository) {
        this.contatoRepository = contatoRepository;
    }

    // ---------------------------------------------------------
    // READ: Listar todos os contatos
    // ---------------------------------------------------------

   @GetMapping("/contatos")
public String listar(Model model) {

    // Busca todos os contatos cadastrados
    model.addAttribute("contatos", contatoRepository.findAll());

    // Envia a quantidade de contatos para o HTML
    model.addAttribute("total", contatoRepository.count());

    return "contatos";
}

    // ---------------------------------------------------------
    // CREATE: Abrir formulário de cadastro
    // ---------------------------------------------------------

    @GetMapping("/contatos/novo")
    public String novo(Model model) {

        // Cria um objeto vazio para preencher o formulário
        model.addAttribute("contato", new Contato());

        // Define o título da página
        model.addAttribute("titulo", "Novo Contato");

        return "formulario";
    }

    // ---------------------------------------------------------
    // CREATE / UPDATE: Salvar contato
    // ---------------------------------------------------------

    @PostMapping("/contatos/salvar")
    public String salvar(
            @Valid @ModelAttribute("contato") Contato contato,
            BindingResult resultado,
            Model model) {

        // Verifica se existem erros de validação
        if (resultado.hasErrors()) {

            // Define o título conforme a operação
            model.addAttribute("titulo",
                    contato.getId() == null
                    ? "Novo Contato"
                    : "Editar Contato");

            // Retorna ao formulário caso existam erros
            return "formulario";
        }

        // Salva um novo contato ou atualiza um existente
        contatoRepository.save(contato);

        // Redireciona para a listagem
        return "redirect:/contatos";
    }

    // ---------------------------------------------------------
    // UPDATE: Abrir formulário preenchido para edição
    // ---------------------------------------------------------

    @GetMapping("/contatos/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {

        // Busca o contato pelo ID
        Contato contato = contatoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Contato não encontrado: " + id));

        // Envia o contato encontrado para o formulário
        model.addAttribute("contato", contato);

        // Define o título da página
        model.addAttribute("titulo", "Editar Contato");

        return "formulario";
    }

    // ---------------------------------------------------------
    // DELETE: Excluir contato
    // ---------------------------------------------------------

    @PostMapping("/contatos/excluir/{id}")
    public String excluir(@PathVariable Long id) {

        // Exclui o contato pelo ID
        contatoRepository.deleteById(id);

        // Retorna para a listagem
        return "redirect:/contatos";
    }

}
