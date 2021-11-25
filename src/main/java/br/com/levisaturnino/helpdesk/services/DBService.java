package br.com.levisaturnino.helpdesk.services;

import br.com.levisaturnino.helpdesk.domain.Chamado;
import br.com.levisaturnino.helpdesk.domain.Cliente;
import br.com.levisaturnino.helpdesk.domain.Tecnico;
import br.com.levisaturnino.helpdesk.domain.enums.Perfil;
import br.com.levisaturnino.helpdesk.domain.enums.Prioridade;
import br.com.levisaturnino.helpdesk.domain.enums.Status;
import br.com.levisaturnino.helpdesk.repositories.ChamadoRepository;
import br.com.levisaturnino.helpdesk.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {
    @Autowired ChamadoRepository chamadoRepository;
    @Autowired PessoaRepository pessoaRepository;
    @Autowired
    private BCryptPasswordEncoder encoder;

    public void instanciaDB(){
        Tecnico tec1= new Tecnico(null,"Levi Dias",
                "123.456.789-00","levisaturnino@gmail.com",encoder.encode("123"));
        tec1.addPerfil(Perfil.ADMIN);

        Tecnico tec2 = new Tecnico(null,"Richard Stallman",
                "550.482.150-95","stallman@gmail.com",encoder.encode("123"));
        Tecnico tec3 = new Tecnico(null,"Claude Elwood Shannon",
                "903.347.070-56","shannon@gmail.com",encoder.encode("123"));
        Tecnico tec4 = new Tecnico(null,"Tim Berners-Lee",
                "271.068.470-54","lee@gmail.com",encoder.encode("123"));
        Tecnico tec5 = new Tecnico(null,"Linus Tovalds",
                "778.556.170-27","linus@gmail.com",encoder.encode("123"));

        Cliente cli1 = new Cliente(null,"Albert Einstein",
                "111.661.890-74","einstein@gmail.com",encoder.encode("123"));
        Cliente cli2 = new Cliente(null,"Marie Curie",
                "322.429.140-06","curie@gmail.com",encoder.encode("123"));
        Cliente cli3 = new Cliente(null,"Charles Darwin",
                "792.043.830-62","darwin@gmail.com",encoder.encode("123"));
        Cliente cli4 = new Cliente(null,"Stephen Hawking",
                "177.409.680-30","hawking@gmail.com",encoder.encode("123"));
        Cliente cli5 = new Cliente(null,"Max Planck",
                "081.399.300-83","planck@gmail.com",encoder.encode("123"));

        Chamado c1 = new Chamado(null, Prioridade.MEDIA,
                Status.ANDAMENTO,"Chamado 1","Teste chamado 1",tec1,cli1);

        Chamado c2 = new Chamado(null, Prioridade.ALTA,
                Status.ABERTO,"Chamado 2","Teste chamado 2",tec1,cli2);

        Chamado c3 = new Chamado(null, Prioridade.MEDIA,
                Status.ANDAMENTO,"Chamado 3","Teste chamado 3",tec2,cli3);

        Chamado c4 = new Chamado(null, Prioridade.MEDIA,
                Status.ANDAMENTO,"Chamado 01","Teste chamado 4",tec3,cli3);

        Chamado c5 = new Chamado(null, Prioridade.MEDIA,
                Status.ANDAMENTO,"Chamado 01","Teste chamado 5",tec2,cli1);

        Chamado c6 = new Chamado(null, Prioridade.MEDIA,
                Status.ANDAMENTO,"Chamado 01","Teste chamado 6",tec1,cli5);

        Chamado c7 = new Chamado(null, Prioridade.MEDIA,
                Status.ANDAMENTO,"Chamado 01","Teste chamado 7",tec4,cli5);

        pessoaRepository.saveAll(Arrays.asList(tec1,tec2,tec3,tec4,tec5,cli1,cli2,cli3,cli4,cli5));
        chamadoRepository.saveAll(Arrays.asList(c1,c2,c3,c4,c5,c6,c7));
    }
}
