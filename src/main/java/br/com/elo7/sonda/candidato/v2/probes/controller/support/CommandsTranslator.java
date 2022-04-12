package br.com.elo7.sonda.candidato.v2.probes.controller.support;

import br.com.elo7.sonda.candidato.v2.probes.model.Command;

import java.util.List;
import java.util.stream.Collectors;

public class CommandsTranslator {

    public static List<Command> representationToModel(List<String> inputs){
        return inputs.stream().map( input -> Command.getByInput(input) ).collect(Collectors.toList());
    }
}
