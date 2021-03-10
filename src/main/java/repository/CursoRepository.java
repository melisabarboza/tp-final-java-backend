package repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import entity.Curso;

@Repository
public interface CursoRepository extends CrudRepository<Curso, Integer> {

}
