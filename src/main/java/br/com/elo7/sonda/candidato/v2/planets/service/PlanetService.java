package br.com.elo7.sonda.candidato.v2.planets.service;

import br.com.elo7.sonda.candidato.v2.infrastructure.errors.exceptions.NotFoundException;
import br.com.elo7.sonda.candidato.v2.infrastructure.errors.exceptions.ValidationException;
import br.com.elo7.sonda.candidato.v2.planets.persistence.PlanetDTO;
import br.com.elo7.sonda.candidato.v2.planets.persistence.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanetService {

    @Autowired
    PlanetRepository repository;

    public PlanetDTO findOne(Long id) {
        return repository.findById(id).orElseThrow( ()-> new NotFoundException("planet not found"));
    }

    public Iterable<? extends PlanetDTO> findAll() {
        return repository.findAll();
    }

    public PlanetDTO save(PlanetDTO planet) {
        return repository.save(planet);
    }

    public void remove(Long id) {repository.deleteById(id);}

    public PlanetDTO update(PlanetDTO planet) {

        PlanetDTO oldPlanet = this.findOne(planet.getId());

        if(oldPlanet.getHeight() > planet.getHeight())
            throw new ValidationException("the height of the planet cannot be less than the current one");

        if(oldPlanet.getWidth() > planet.getWidth())
            throw new ValidationException("the width of twhe planet cannot be less than the current one");

        return this.save(planet);
    }
}
