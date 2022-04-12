package br.com.elo7.sonda.candidato.v2.probes.controller.support;

import br.com.elo7.sonda.candidato.v2.infrastructure.errors.exceptions.ValidationException;
import br.com.elo7.sonda.candidato.v2.probes.model.Direction;
import br.com.elo7.sonda.candidato.v2.probes.model.Planet;
import br.com.elo7.sonda.candidato.v2.probes.model.Coordinate;
import br.com.elo7.sonda.candidato.v2.probes.model.Probe;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static br.com.elo7.sonda.candidato.v2.infrastructure.helpers.LinksHelper.extractId;

@Component
public class ProbeAssembler implements RepresentationModelAssembler<Probe, ProbeRepresentation> {

    private static final String SELF = "/probes/{id}";
    private static final String ON_PLANET = "/planets/{id}";

    @Override
    public ProbeRepresentation toModel(Probe probe) {
        ProbeRepresentation representation = new ProbeRepresentation(probe);
        representation.add(Link.of(SELF.replace("{id}",String.valueOf(representation.getId()))));
        representation.add(Link.of(ON_PLANET.replace("{id}",String.valueOf(representation.getId())),"on-planet"));
        return representation;
    }

    @Override
    public CollectionModel<ProbeRepresentation> toCollectionModel(Iterable<? extends Probe> entities) {
        return RepresentationModelAssembler.super.toCollectionModel(entities);
    }

    public Probe fromModel(ProbeRepresentation probeRepresentation) {

        long planetId = extractId(probeRepresentation.getLink("on-planet").orElseThrow(
            () -> new ValidationException("id planet is required")
        ));

        return new Probe(
            probeRepresentation.getId(),
            probeRepresentation.getName(),
            new Planet(planetId),
            new Coordinate(probeRepresentation.getPositionAxisX(),probeRepresentation.getPositionAxisY()),
            Direction.valueOf(probeRepresentation.getDirection())
        );
    }
}
