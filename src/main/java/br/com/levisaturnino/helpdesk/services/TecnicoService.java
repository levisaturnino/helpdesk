package br.com.levisaturnino.helpdesk.services;

import br.com.levisaturnino.helpdesk.domain.Tecnico;
import br.com.levisaturnino.helpdesk.exceptions.ObjectnotFoundException;
import br.com.levisaturnino.helpdesk.repositories.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TecnicoService {

    @Autowired
    TecnicoRepository tecnicoRepository;

    public Tecnico findById( Integer id){
        Optional<Tecnico> obj = tecnicoRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não Encontrado! id: "+id));
    }
}
