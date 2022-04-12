package br.com.elo7.sonda.candidato.v2.probes.controller.support;

import br.com.elo7.sonda.candidato.v2.infrastructure.errors.exceptions.ValidationException;
import br.com.elo7.sonda.candidato.v2.planets.controller.support.CommandsRepresentation;
import br.com.elo7.sonda.candidato.v2.probes.model.Direction;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ProbeValidator {
    public static void validation(ProbeRepresentation probe) {
        Set<String> errors = new HashSet<String>();
        if(probe.getLink("on-planet").isEmpty()) errors.add("id planet is required");
        if (probe.getId() < 0 ) errors.add("id must be greater than 0");
        if(probe.getPositionAxisX() < 0) errors.add("positionAxisX must be greater than 0");
        if(probe.getPositionAxisY() < 0) errors.add("positionAxisY must be greater than 0");
        if(probe.getName() == null || probe.getName().isEmpty()) errors.add("name is required");
        if(probe.getDirection() == null) errors.add("direction is required");
        if(Arrays.stream(Direction.values()).noneMatch(direction -> direction.name().equals(probe.getDirection())))
            errors.add("direction must be NORTH, SOUTH, EAST or WEST");
        if(errors.size() > 0) throw  new ValidationException(errors);
    }
}
