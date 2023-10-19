package com.iric101v.practica.servicios;


import com.iric101v.practica.modelos.Materia;
import com.iric101v.practica.repositorios.AlumnoRepository;
import com.iric101v.practica.utils.Excepcion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MateriaServiceImpl implements MateriaService {


    @Autowired
    private AlumnoRepository alumnoRepository;


    public Materia getAlumnoById(Integer id) throws Excepcion
    {

        Optional<Materia> optionalAlumno = alumnoRepository.findById(id);
        return optionalAlumno.orElse(null);
    }

    @Override
    public Materia getMateriaById(Integer id) throws Excepcion {
        return null;
    }

    @Override
    public Materia getAlumnoByMatricula(Integer id) throws Excepcion
    {
        Optional<Materia> optionalAlumno = alumnoRepository.findById(id);
        return optionalAlumno.orElse(null);
    }
    @Override
    public Materia createAlumno(Materia alumno) throws Excepcion {
        Optional<Materia> optionalMateria = alumnoRepository.findById(alumno.getId());
        if (optionalMateria.isPresent())
            throw new Excepcion(HttpStatus.CONFLICT, "La Matricula '" + alumno + "' Ya fué registrada anteriormente en la base de datos");


        return alumnoRepository.save(alumno);
    }

    @Override
    public List<Materia> getAllAlumnos() {

        return alumnoRepository.findAll();
    }

    @Override
    public void deleteAlumno(Integer id) {
        Materia alumnoExistente = getMateriaById(id);
        if(alumnoExistente==null)
            throw new Excepcion(HttpStatus.NOT_FOUND,"No existe ningun registro en la base de datos de Alumnos que coincida con el id '"+id.toString()+"'");

        alumnoRepository.delete(alumnoExistente);
    }
}