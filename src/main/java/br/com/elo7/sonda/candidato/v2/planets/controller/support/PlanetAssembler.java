package br.com.elo7.sonda.candidato.v2.planets.controller.support;

import br.com.elo7.sonda.candidato.v2.planets.persistence.PlanetDTO;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class PlanetAssembler implements RepresentationModelAssembler<PlanetDTO,PlanetRepresentation> {

    private static final String SELF = "/planets/{id}";

    @Override
    public PlanetRepresentation toModel(PlanetDTO planet) {
        PlanetRepresentation representation = new PlanetRepresentation(planet);
        representation.add(Link.of(SELF.replace("{id}",String.valueOf(representation.getId()))));
        return representation;
    }

    @Override
    public CollectionModel<PlanetRepresentation> toCollectionModel(Iterable<? extends PlanetDTO> planets) {
        return RepresentationModelAssembler.super.toCollectionModel(planets);
    }

    public PlanetDTO fromModel(PlanetRepresentation planetRepresentation) {
        return new PlanetDTO(
            planetRepresentation.getId(),
            planetRepresentation.getName(),
            planetRepresentation.getWidth(),
            planetRepresentation.getHeight()
        );
    }
}
