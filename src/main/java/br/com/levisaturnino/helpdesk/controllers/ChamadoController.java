package br.com.levisaturnino.helpdesk.controllers;

import br.com.levisaturnino.helpdesk.domain.Chamado;
import br.com.levisaturnino.helpdesk.domain.dtos.ChamadoDTO;
import br.com.levisaturnino.helpdesk.services.ChamadoService;
import br.com.levisaturnino.helpdesk.services.ChamadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/chamados")
public class ChamadoController {

    @Autowired
    ChamadoService chamadoService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ChamadoDTO> findById(@PathVariable Integer id){
        Chamado obj = chamadoService.findById(id);
        return ResponseEntity.ok().body(new ChamadoDTO(obj));
    }

    @GetMapping()
    public ResponseEntity<List<ChamadoDTO>> findByAll(){
        List<Chamado> list = chamadoService.findAll();
        List<ChamadoDTO> listDTO = list.stream().map(ChamadoDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    public ResponseEntity<ChamadoDTO> create(@RequestBody ChamadoDTO objDTO){
        Chamado obj = chamadoService.create(objDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<ChamadoDTO> update(@PathVariable Integer id,@Valid ChamadoDTO objDTO){
        Chamado obj = chamadoService.update(id,objDTO);
        return ResponseEntity.ok().body(new ChamadoDTO(obj));
    }

}


























