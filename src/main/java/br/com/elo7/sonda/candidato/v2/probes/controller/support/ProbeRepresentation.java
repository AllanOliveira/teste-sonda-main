package br.com.elo7.sonda.candidato.v2.probes.controller.support;

import br.com.elo7.sonda.candidato.v2.probes.model.Probe;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Relation(value = "probe", collectionRelation = "probes")
public class ProbeRepresentation extends RepresentationModel<ProbeRepresentation> {

    private long id;
    private String name;
    private int  positionAxisX;
    private int  positionAxisY;
    private String direction;

    public ProbeRepresentation(){}

    public ProbeRepresentation(Probe probe) {
        this.id = probe.getId();
        this.name = probe.getName();
        this.positionAxisX = probe.getCoordinate().getHorizontalAxis();
        this.positionAxisY = probe.getCoordinate().getVerticalAxis();
        this.direction = probe.getDirection().name();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPositionAxisX() {
        return positionAxisX;
    }

    public int getPositionAxisY() {
        return positionAxisY;
    }

    public String getDirection() {
        return direction;
    }
}
