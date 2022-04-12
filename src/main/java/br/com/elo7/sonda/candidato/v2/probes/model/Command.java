package br.com.elo7.sonda.candidato.v2.probes.model;

import br.com.elo7.sonda.candidato.v2.infrastructure.errors.exceptions.ValidationException;

import java.util.Arrays;

public enum Command {

    MOVE_FORWARD("M"){ @Override public void execute(Probe probe) { probe.moveForward(); }},
    TURN_LEFT("L") { @Override public void execute(Probe probe) { probe.turnLeft(); }},
    TURN_RIGHT("R") { @Override public void execute(Probe probe) { probe.turnRight(); }};

    private final String input;

    Command(String input) {
        this.input = input;
    }

    public static Command getByInput(String input){
        return Arrays
                .stream(Command.values())
                .filter( command -> command.input.equals(input.toUpperCase()) )
                .findFirst()
                .orElseThrow( () -> new ValidationException("command with input "+input+" not found"));
    }

    public abstract void execute(Probe probe);


}
