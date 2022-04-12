package br.com.elo7.sonda.candidato.v2.probes.service;

import br.com.elo7.sonda.candidato.v2.infrastructure.errors.exceptions.NotFoundException;
import br.com.elo7.sonda.candidato.v2.planets.persistence.PlanetDTO;
import br.com.elo7.sonda.candidato.v2.planets.persistence.PlanetRepository;
import br.com.elo7.sonda.candidato.v2.probes.model.*;
import br.com.elo7.sonda.candidato.v2.probes.persistence.ProbeDTO;
import br.com.elo7.sonda.candidato.v2.probes.persistence.ProbeRepository;
import br.com.elo7.sonda.candidato.v2.probes.persistence.ProbeTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProbeService {

    @Autowired
    ProbeRepository probeRepository;

    @Autowired
    PlanetRepository planetRepository;

    public Probe findOne(Long probeId) {

        ProbeDTO probeDTO = probeRepository.findById(probeId)
                .orElseThrow(() -> new NotFoundException("probe not found"));

        PlanetDTO planetDTO = planetRepository.findById(probeDTO.getPlanetId())
                .orElseThrow(() -> new NotFoundException("planet of probe" + probeDTO.getId() + " not found"));

        return ProbeTranslator.toModel(probeDTO, planetDTO);
    }

    public Probe save(Probe probe) {
        planetRepository.findById(probe.getPlanet().getId()).orElseThrow(() -> new NotFoundException("planet not found"));
        return ProbeTranslator.toModel(probeRepository.save(new ProbeDTO(probe)));
    }

    public Probe processesCommands(Long probeId, List<Command> commands) {
        Probe probe = this.findOne(probeId);
        commands.stream().forEach(command -> {
            command.execute(probe);
        });
        return this.save(probe);
    }

}
