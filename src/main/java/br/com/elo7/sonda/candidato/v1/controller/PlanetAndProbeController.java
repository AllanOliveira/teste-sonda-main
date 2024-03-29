package br.com.elo7.sonda.candidato.v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.elo7.sonda.candidato.v1.dto.InputDTO;
import br.com.elo7.sonda.candidato.v1.model.Probe;
import br.com.elo7.sonda.candidato.v1.service.ProbeService_;

@Controller
@RequestMapping("/planet-with-probes")
public class PlanetAndProbeController {
	@Autowired
	private ProbeService_ probeService;

	@PostMapping
    public ResponseEntity<List<Probe>> register(@RequestBody InputDTO inputDto) {
		return ResponseEntity.ok(probeService.landProbes(inputDto));        
    }
}
