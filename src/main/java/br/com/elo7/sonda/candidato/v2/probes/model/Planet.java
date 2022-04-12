package br.com.elo7.sonda.candidato.v2.probes.model;

public class Planet {
    private long id;
    private int with;
    private int height;

    public Planet(long id) {
        this.id = id;
    }

    public Planet(long planetId, int width, int height) {
        this.id = planetId;
        this.with = width;
        this.height = height;
    }

    public int getWith() {
        return with;
    }

    public int getHeight() {
        return height;
    }

    public long getId() {
        return id;
    }
}
