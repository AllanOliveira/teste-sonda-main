package br.com.elo7.sonda.candidato.v2.probes.model;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;

public class Probe {

    private final long id;
    private final String name;
    private final Planet planet;
    private Coordinate coordinate;
    private Direction direction;

    private static final LinkedList<Direction> directions = new LinkedList<Direction>(
        Arrays.stream(Direction.values()).toList()
    );

    public Probe(long id, String name, Planet planet, Coordinate coordinate, Direction direction) {
        this.id = id;
        this.name = name;
        this.planet = planet;
        this.coordinate = coordinate;
        this.direction = direction;
    }

    public void turnRight(){
        ListIterator<Direction> iterator = directions.listIterator(directions.indexOf(this.direction)+1);
        this.direction = iterator.hasNext() ? iterator.next() : directions.getFirst();
    }

    public void turnLeft(){
        ListIterator<Direction> iterator = directions.listIterator(directions.indexOf(this.direction));
        this.direction = iterator.hasPrevious() ? iterator.previous() : directions.getLast();
    }

    public void moveForward(){
        this.coordinate = this.direction.moveOn(1,this.coordinate,this.planet);
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Planet getPlanet() {
        return planet;
    }

    public Coordinate getCoordinate(){
        return coordinate;
    }

    public Direction getDirection(){
        return direction;
    }
}
