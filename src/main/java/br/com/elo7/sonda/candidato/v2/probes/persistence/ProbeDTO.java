package br.com.elo7.sonda.candidato.v2.probes.persistence;

import br.com.elo7.sonda.candidato.v2.probes.model.Probe;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "probe")
public class ProbeDTO {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "id_planet", nullable = false)
    private long planetId;

    @Column(name = "ds_name", nullable = false)
    private String name;

    @Column(name = "ds_direction", nullable = false)
    private String direction;

    @Column(name = "vl_position_vertical", nullable = false)
    private int positionVerticalAxis;

    @Column(name = "vl_horizontal_vertical", nullable = false)
    private int positionHorizontalAxis;

    public ProbeDTO(){}

    public ProbeDTO(Probe probe) {
        if(probe.getId() > 0) this.id = probe.getId();
        this.planetId = probe.getPlanet().getId();
        this.name = probe.getName();
        this.direction = probe.getDirection().name();
        this.positionHorizontalAxis = probe.getCoordinate().getHorizontalAxis();
        this.positionVerticalAxis = probe.getCoordinate().getVerticalAxis();
    }

    public long getId() {
        return id;
    }

    public long getPlanetId() {
        return planetId;
    }

    public String getName() {
        return name;
    }

    public String getDirection() {
        return direction;
    }

    public int getPositionVerticalAxis() {
        return positionVerticalAxis;
    }

    public int getPositionHorizontalAxis() {
        return positionHorizontalAxis;
    }
}
