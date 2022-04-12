package br.com.elo7.sonda.candidato.v2.planets.controller.support;

import br.com.elo7.sonda.candidato.v2.infrastructure.errors.exceptions.ValidationException;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class PlanetValidator {

    public static void validation(PlanetRepresentation planet){
        Set<String> errors = new HashSet<String>();
        if (planet.getId() < 0 ) errors.add("id must be greater than 0");
        if (planet.getWidth() <= 0 ) errors.add("width must be greater than 0");
        if (planet.getHeight() <= 0 ) errors.add("height must be greater than 0");
        if (planet.getName() == null || planet.getName().isBlank() ) errors.add("name is required");
        if(errors.size() > 0) throw  new ValidationException(errors);
    }
}
