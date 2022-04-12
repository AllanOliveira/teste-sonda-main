package br.com.elo7.sonda.candidato.v2.planets.controller.support;

import br.com.elo7.sonda.candidato.v2.probes.model.Command;
import org.springframework.hateoas.server.core.Relation;

import java.util.List;
import java.util.stream.Collectors;

@Relation(value = "command", collectionRelation = "commands")
public class CommandsRepresentation {

    private List<String> commands;

    public List<Command> getCommands() {

        return this.commands.stream().map( input -> Command.getByInput(input) ).collect(Collectors.toList());
    }


}
