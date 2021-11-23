package br.com.levisaturnino.helpdesk.controllers;

import br.com.levisaturnino.helpdesk.domain.Tecnico;
import br.com.levisaturnino.helpdesk.services.TecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tecnicos")
public class TecnicoController {

    @Autowired
    TecnicoService tecnicoService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Tecnico> findById(@PathVariable Integer id){

        Tecnico obj = tecnicoService.findById(id);

        return ResponseEntity.ok().body(obj);
    }
}
