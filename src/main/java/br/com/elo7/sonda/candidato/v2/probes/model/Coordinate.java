package br.com.elo7.sonda.candidato.v2.probes.model;

public class Coordinate {
    private int verticalAxis;
    private int horizontalAxis;

    public Coordinate(int horizontalAxis, int verticalAxis) {
        this.horizontalAxis = horizontalAxis;
        this.verticalAxis = verticalAxis;
    }

    public int getVerticalAxis(){
        return this.verticalAxis;
    }

    public int getHorizontalAxis(){
        return this.horizontalAxis;
    }
}
