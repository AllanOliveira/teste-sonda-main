package br.com.elo7.sonda.candidato.v2.probes.persistence;

import br.com.elo7.sonda.candidato.v2.planets.persistence.PlanetDTO;
import br.com.elo7.sonda.candidato.v2.probes.model.Direction;
import br.com.elo7.sonda.candidato.v2.probes.model.Planet;
import br.com.elo7.sonda.candidato.v2.probes.model.Coordinate;
import br.com.elo7.sonda.candidato.v2.probes.model.Probe;

public class ProbeTranslator {

    public static Probe toModel(ProbeDTO probeDTO){
        return new Probe(
            probeDTO.getId(),
            probeDTO.getName(),
            new Planet(probeDTO.getPlanetId()),
            new Coordinate(probeDTO.getPositionHorizontalAxis(),probeDTO.getPositionVerticalAxis()),
            Direction.valueOf(probeDTO.getDirection())
        );
    }

    public static Probe toModel(ProbeDTO probeDTO, PlanetDTO planetDTO) {
        return new Probe(
            probeDTO.getId(),
            probeDTO.getName(),
            new Planet(probeDTO.getPlanetId(),planetDTO.getWidth(),planetDTO.getHeight()),
            new Coordinate(probeDTO.getPositionHorizontalAxis(),probeDTO.getPositionVerticalAxis()),
            Direction.valueOf(probeDTO.getDirection())
        );
    }
}
