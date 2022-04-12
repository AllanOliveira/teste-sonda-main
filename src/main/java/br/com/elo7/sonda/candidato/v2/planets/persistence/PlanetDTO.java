package br.com.elo7.sonda.candidato.v2.planets.persistence;

import javax.persistence.*;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "planet")
public class PlanetDTO {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "ds_name", nullable = false)
    private String name;

    @Column(name = "vl_width", nullable = false)
    private int width;

    @Column(name = "vl_height", nullable = false)
    private int height;

    public PlanetDTO(){}

    public PlanetDTO(long id, String name, int width, int height) {
        this.id = id;
        this.name = name;
        this.width = width;
        this.height = height;
    }

    public long getId() {
        return id;
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

    public PlanetDTO setId(long id ){
        this.id = id;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlanetDTO planet = (PlanetDTO) o;
        return id == planet.id && width == planet.width && height == planet.height && Objects.equals(name, planet.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, width, height);
    }
}
