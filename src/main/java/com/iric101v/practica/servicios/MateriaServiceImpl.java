package com.iric101v.practica.servicios;


import com.iric101v.practica.modelos.Materia;
import com.iric101v.practica.repositorios.MateriaRepository;
import com.iric101v.practica.utils.Excepcion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MateriaServiceImpl implements MateriaService {


    @Autowired
    private MateriaRepository materiaRepository;


        @Override
    public Materia getMateriaById(Integer id) throws Excepcion {
        return null;
    }
}