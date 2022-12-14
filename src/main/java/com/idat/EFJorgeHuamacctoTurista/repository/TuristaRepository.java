package com.idat.EFJorgeHuamacctoTurista.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.EFJorgeHuamacctoTurista.model.Turista;

@Repository
public interface TuristaRepository extends JpaRepository<Turista, Integer> {

}
