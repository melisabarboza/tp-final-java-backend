package repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import entity.Organizacion;

@Repository
public interface OrganizacionRepository extends CrudRepository<Organizacion, Integer> {

}
