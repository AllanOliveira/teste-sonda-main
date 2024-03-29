package br.com.elo7.sonda.candidato.v1.persistence;

import java.util.Optional;

import br.com.elo7.sonda.candidato.v1.model.Planet;

public interface Planets {

	void save(Planet planet);

	Optional<Planet> findById(int id);

}
