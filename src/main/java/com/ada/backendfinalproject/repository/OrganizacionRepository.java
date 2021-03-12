package com.ada.backendfinalproject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ada.backendfinalproject.entity.Organizacion;

@Repository
public interface OrganizacionRepository extends CrudRepository<Organizacion, Integer> {

}
