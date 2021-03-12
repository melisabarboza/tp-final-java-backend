package com.ada.backendfinalproject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ada.backendfinalproject.entity.Participante;

@Repository
public interface ParticipanteRepository extends CrudRepository<Participante, Integer> {

}
