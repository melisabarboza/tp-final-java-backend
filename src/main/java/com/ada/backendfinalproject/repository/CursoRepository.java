package com.ada.backendfinalproject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ada.backendfinalproject.entity.Curso;

@Repository
public interface CursoRepository extends CrudRepository<Curso, Integer> {

	Iterable<Curso> findByCategoria(String categoria);

	Iterable<Curso> findByIdOrganizacion(Integer idOrganizacion);

}
