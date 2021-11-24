package br.com.levisaturnino.helpdesk.services;

import br.com.levisaturnino.helpdesk.domain.Chamado;
import br.com.levisaturnino.helpdesk.domain.Cliente;
import br.com.levisaturnino.helpdesk.domain.Tecnico;
import br.com.levisaturnino.helpdesk.domain.dtos.ChamadoDTO;
import br.com.levisaturnino.helpdesk.domain.enums.Prioridade;
import br.com.levisaturnino.helpdesk.domain.enums.Status;
import br.com.levisaturnino.helpdesk.repositories.ChamadoRepository;

import br.com.levisaturnino.helpdesk.repositories.ClienteRepository;
import br.com.levisaturnino.helpdesk.repositories.TecnicoRepository;
import br.com.levisaturnino.helpdesk.services.exceptions.ObjectnotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ChamadoService {

    @Autowired
    private ChamadoRepository repository;

    @Autowired
    private TecnicoRepository tecnicoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public Chamado findById(Integer id) {
        Optional<Chamado> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! Id: " + id));
    }

    public List<Chamado> findAll() {
        return repository.findAll();
    }

    public Chamado create(ChamadoDTO objDTO) {
        return repository.save(newChamado(objDTO));
    }

    public Chamado newChamado(ChamadoDTO objDTO) {
        Optional<Tecnico> tecnico = tecnicoRepository.findById(objDTO.getTecnico());
        Optional<Cliente> cliente = clienteRepository.findById(objDTO.getCliente());

       tecnico.orElseThrow(() ->new ObjectnotFoundException("Técnico não encontrado! id: "+objDTO.getTecnico()));
       cliente.orElseThrow(() ->new ObjectnotFoundException("Cliente não encontrado! id: "+objDTO.getCliente()));

        Chamado chamado = new Chamado();

        if(objDTO.getId() != null){
            chamado.setId(objDTO.getId());
        }

        if(objDTO.getStatus().equals(2)){
            chamado.setDataFechamento(LocalDate.now());
        }

        chamado.setTecnico(tecnico.get());
        chamado.setCliente(cliente.get());
        chamado.setPrioridade(Prioridade.toEnum(objDTO.getPrioridade()));
        chamado.setStatus(Status.toEnum(objDTO.getStatus()));
        chamado.setTitulo(objDTO.getTitulo());
        chamado.setObservacoes(objDTO.getObservacoes());
        return chamado;
    }

    public Chamado update(Integer id,@Valid ChamadoDTO objDTO) {
        objDTO.setId(id);
        Chamado oldObj = findById(id);
        oldObj = newChamado(objDTO);
        return repository.save(oldObj);
    }
}



















