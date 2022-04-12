package br.com.elo7.sonda.candidato.v2.planets.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanetRepository extends CrudRepository<PlanetDTO, Long> {

}
