package com.iric101v.practica.repositorios;


import com.iric101v.practica.modelos.Materia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MateriaRepository extends JpaRepository<Materia,Integer>
{

    Optional<Materia> findById(Integer id);

}
