package br.com.elo7.sonda.candidato.v2.probes.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProbeRepository extends CrudRepository<ProbeDTO, Long> {
}
