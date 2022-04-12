package br.com.elo7.sonda.candidato.v2.planets.controller;

import br.com.elo7.sonda.candidato.v2.planets.controller.support.PlanetAssembler;
import br.com.elo7.sonda.candidato.v2.planets.controller.support.PlanetRepresentation;
import br.com.elo7.sonda.candidato.v2.planets.persistence.PlanetDTO;
import br.com.elo7.sonda.candidato.v2.planets.service.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static br.com.elo7.sonda.candidato.v2.planets.controller.support.PlanetValidator.validation;

@Controller
@RequestMapping("/planets")
public class PlanetController {

    @Autowired
    private PlanetAssembler assembler;

    @Autowired
    private PlanetService service;

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PlanetRepresentation> findOne(@PathVariable Long id) {
        return ResponseEntity.ok( assembler.toModel(service.findOne(id)));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CollectionModel<PlanetRepresentation>> findAll() {
        return ResponseEntity.ok( assembler.toCollectionModel(service.findAll()) );
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PlanetRepresentation> add(@RequestBody PlanetRepresentation planetRepresentation) {
        validation(planetRepresentation);
        PlanetDTO planet = assembler.fromModel(planetRepresentation);
        return ResponseEntity.ok(assembler.toModel(service.save(planet)));
    }

    @DeleteMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> remove(@PathVariable Long id) {
        service.remove(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PlanetRepresentation> update(@RequestBody PlanetRepresentation planetRepresentation) {
        validation(planetRepresentation);
        PlanetDTO planet = assembler.fromModel(planetRepresentation);
        return ResponseEntity.ok( assembler.toModel(service.update(planet)));
    }

}
