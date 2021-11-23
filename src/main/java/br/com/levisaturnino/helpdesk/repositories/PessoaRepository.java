package br.com.levisaturnino.helpdesk.repositories;

import br.com.levisaturnino.helpdesk.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa,Integer> {
}
