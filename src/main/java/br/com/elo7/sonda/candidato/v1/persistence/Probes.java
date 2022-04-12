package br.com.elo7.sonda.candidato.v1.persistence;

import java.util.Optional;

import br.com.elo7.sonda.candidato.v1.model.Probe;

public interface Probes {

	void save(Probe probe);

	Optional<Probe> findById(int id);

}
