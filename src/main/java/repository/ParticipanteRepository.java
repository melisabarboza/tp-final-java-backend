package repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import entity.Participante;

@Repository
public interface ParticipanteRepository extends CrudRepository<Participante, Integer> {

}
