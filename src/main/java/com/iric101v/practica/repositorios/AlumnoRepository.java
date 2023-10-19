package com.iric101v.practica.repositorios;

import com.iric101v.practica.modelos.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno,Integer>
{

    Optional<Alumno> findByMatricula(Integer matricula);

}
