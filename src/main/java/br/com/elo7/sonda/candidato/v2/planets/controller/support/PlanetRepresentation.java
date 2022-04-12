package br.com.elo7.sonda.candidato.v2.planets.controller.support;

import br.com.elo7.sonda.candidato.v2.planets.persistence.PlanetDTO;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Relation(value = "planet", collectionRelation = "planets")
public class PlanetRepresentation extends RepresentationModel<PlanetRepresentation> {

    private long id;
    private String name;
    private int width;
    private int height;

    public PlanetRepresentation(){}

    public PlanetRepresentation(long id, String name, int width, int height) {
        this.id = id;
        this.name = name;
        this.width = width;
        this.height = height;
    }

    public PlanetRepresentation(PlanetDTO model) {
        this.id = model.getId();
        this.name = model.getName();
        this.width = model.getWidth();
        this.height = model.getHeight();
    }

    public String getName() {
        return name;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public long getId() {
        return id;
    }
}
