package com.iric101v.practica.servicios;

import com.iric101v.practica.modelos.Alumno;
import com.iric101v.practica.repositorios.AlumnoRepository;
import com.iric101v.practica.utils.Excepcion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AlumnoServiceImpl implements AlumnoService {


    @Autowired
    private AlumnoRepository alumnoRepository;

    @Override
    public Alumno getAlumnoById(Integer id) throws Excepcion
    {

        Optional<Alumno> optionalAlumno = alumnoRepository.findById(id);
        return optionalAlumno.orElse(null);
    }

    @Override
    public Alumno getAlumnoByMatricula(Integer matricula) throws Excepcion
    {
        Optional<Alumno> optionalAlumno = alumnoRepository.findByMatricula(matricula);
        return optionalAlumno.orElse(null);
    }
    @Override
    public Alumno createAlumno(Alumno alumno) throws Excepcion {
        Optional<Alumno> optionalAlumno = alumnoRepository.findByMatricula(alumno.getMatricula());
        if (optionalAlumno.isPresent())
            throw new Excepcion(HttpStatus.CONFLICT, "La Matricula '" + alumno.getMatricula() + "' Ya fué registrada anteriormente en la base de datos");


        return alumnoRepository.save(alumno);
    }

    @Override
    public List<Alumno> getAllAlumnos() {

        return alumnoRepository.findAll();
    }

    @Override
    public void deleteAlumno(Integer id) {
        Alumno alumnoExistente = getAlumnoById(id);
        if(alumnoExistente==null)
            throw new Excepcion(HttpStatus.NOT_FOUND,"No existe ningun registro en la base de datos de Alumnos que coincida con el id '"+id.toString()+"'");

        alumnoRepository.delete(alumnoExistente);
    }
}