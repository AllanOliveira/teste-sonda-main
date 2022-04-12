package br.com.elo7.sonda.candidato.v2.probes.controller;

import br.com.elo7.sonda.candidato.v2.planets.controller.support.CommandsRepresentation;
import br.com.elo7.sonda.candidato.v2.probes.controller.support.ProbeAssembler;
import br.com.elo7.sonda.candidato.v2.probes.controller.support.ProbeRepresentation;
import br.com.elo7.sonda.candidato.v2.probes.model.Probe;
import br.com.elo7.sonda.candidato.v2.probes.service.ProbeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static br.com.elo7.sonda.candidato.v2.probes.controller.support.ProbeValidator.validation;

@Controller
@RequestMapping("/probes")
public class ProbeController {

    @Autowired
    private ProbeAssembler assembler;

    @Autowired
    private ProbeService service;

    @GetMapping(path = "/{probeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProbeRepresentation> findOne( @PathVariable Long probeId) {
        return ResponseEntity.ok( assembler.toModel(service.findOne(probeId)));
    }

   @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProbeRepresentation> create( @RequestBody ProbeRepresentation probeRepresentation) {
       validation(probeRepresentation);
        Probe probe = assembler.fromModel(probeRepresentation);
        return ResponseEntity.ok(assembler.toModel(service.save(probe)));
    }

    @PostMapping(path = "/{probeId}/commands", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProbeRepresentation> commands( @PathVariable Long probeId, @RequestBody() CommandsRepresentation commandsRepresentation) {
        return ResponseEntity.ok(
            assembler.toModel(service.processesCommands(probeId, commandsRepresentation.getCommands() ))
        );
    }
}
