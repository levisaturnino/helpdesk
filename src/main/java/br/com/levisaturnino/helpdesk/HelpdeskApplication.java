package br.com.levisaturnino.helpdesk;

import br.com.levisaturnino.helpdesk.domain.Chamado;
import br.com.levisaturnino.helpdesk.domain.Cliente;
import br.com.levisaturnino.helpdesk.domain.Tecnico;
import br.com.levisaturnino.helpdesk.domain.enums.Perfil;
import br.com.levisaturnino.helpdesk.domain.enums.Prioridade;
import br.com.levisaturnino.helpdesk.domain.enums.Status;
import br.com.levisaturnino.helpdesk.repositories.ChamadoRepository;
import br.com.levisaturnino.helpdesk.repositories.ClienteRepository;
import br.com.levisaturnino.helpdesk.repositories.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class HelpdeskApplication  {
	public static void main(String[] args) {
		SpringApplication.run(HelpdeskApplication.class, args);
	}

}
