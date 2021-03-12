package com.ada.backendfinalproject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ada.backendfinalproject.entity.Inscripcion;

@Repository
public interface InscripcionRepository extends CrudRepository<Inscripcion, Integer> {

}
