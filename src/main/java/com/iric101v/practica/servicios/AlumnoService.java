package com.iric101v.practica.servicios;

import com.iric101v.practica.modelos.Alumno;
import com.iric101v.practica.utils.Excepcion;

import java.util.List;

public interface AlumnoService
{
    Alumno getAlumnoById(Integer id) throws Excepcion;
    Alumno getAlumnoByMatricula(Integer matricula) throws Excepcion;
    List<Alumno> getAllAlumnos();
    Alumno createAlumno (Alumno alumno)throws Excepcion;
    void deleteAlumno(Integer id);

}