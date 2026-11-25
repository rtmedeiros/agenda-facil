
package br.com.agenda_facil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.agenda_facil.model.Contato;

// @Repository identifica esta interface como responsável
// pelo acesso aos dados (a camada que conversa com o banco).
@Repository

// extends JpaRepository<Contato, Long>:
//
// Contato -> entidade que será gravada e consultada no banco.
//
// Long -> tipo de dado do identificador (atributo id).
//
// O Spring Data JPA cria automaticamente a implementação
// dessa interface quando a aplicação inicia.

public interface ContatoRepository extends JpaRepository<Contato, Long> {

    // O JpaRepository já fornece os métodos necessários para o CRUD:

    // save()       -> cadastrar ou atualizar um contato.
    // findAll()    -> listar todos os contatos.
    // findById()   -> buscar um contato pelo ID.
    // deleteById() -> excluir um contato pelo ID.
    // count()      -> contar quantos contatos existem.

}
