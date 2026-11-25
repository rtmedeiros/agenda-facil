
package br.com.agenda_facil.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

// @Entity informa ao JPA que esta classe representa uma tabela no banco

// @Table define o nome da tabela que será criada no banco

@Entity
@Table(name = "contatos")

public class Contato {

    // @Id define o atributo que será a chave primária da tabela

    @Id

    // @GeneratedValue gera o auto-incremento
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @NotBlank impede que o nome seja vazio ou tenha somente espaços
    @NotBlank(message = "O nome é obrigatório.")
    @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres.")
    private String nome;

    // @NotBlank impede que o telefone seja vazio
    @NotBlank(message = "O telefone é obrigatório.")
    @Size(max = 20, message = "O telefone deve ter no máximo 20 caracteres.")
    private String telefone;

    // @NotBlank impede que o email seja vazio
    // @Email verifica se o email possui um formato válido
    @NotBlank(message = "O email é obrigatório.")
    @Email(message = "O email deve ser válido.")
    @Size(max = 100, message = "O email deve ter no máximo 100 caracteres.")
    private String email;

    // Construtor vazio exigido pelo JPA
    public Contato() {
    }

    // Getters: permitem consultar os atributos

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    // Setters: permitem modificar os atributos

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
