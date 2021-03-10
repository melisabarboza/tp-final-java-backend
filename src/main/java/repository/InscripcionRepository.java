package repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import entity.Inscripcion;

@Repository
public interface InscripcionRepository extends CrudRepository<Inscripcion, Integer> {

}
