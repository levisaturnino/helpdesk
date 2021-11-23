package br.com.levisaturnino.helpdesk.repositories;

import br.com.levisaturnino.helpdesk.domain.Pessoa;
import br.com.levisaturnino.helpdesk.domain.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TecnicoRepository extends JpaRepository<Tecnico,Integer> {
}
