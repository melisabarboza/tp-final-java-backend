package com.ada.backendfinalproject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ada.backendfinalproject.entity.Representante;

@Repository
public interface RepresentanteRepository extends CrudRepository<Representante, Integer> {

}
