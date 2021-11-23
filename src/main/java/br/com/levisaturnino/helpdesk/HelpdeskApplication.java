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
public class HelpdeskApplication implements CommandLineRunner {

	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	TecnicoRepository tecnicoRepository;
	@Autowired
	ChamadoRepository chamadoRepository;

	public static void main(String[] args) {
		SpringApplication.run(HelpdeskApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Tecnico tecnico = new Tecnico(null,"Levi Dias",
				"03678716458","levisaturnino@gmail.com","123");
		tecnico.addPerfis(Perfil.ADMIN);

		Cliente cli = new Cliente(null,"Saturnino",
				"03678716459","saturnino@gmail.com","123");


		Chamado c1 = new Chamado(null, Prioridade.MEDIA,
				Status.ANDAMENTO,"Chamado 01","Primeiro chamado",tecnico,cli);

		tecnicoRepository.saveAll(Arrays.asList(tecnico));
		clienteRepository.saveAll(Arrays.asList(cli));
		chamadoRepository.saveAll(Arrays.asList(c1));
	}
}
