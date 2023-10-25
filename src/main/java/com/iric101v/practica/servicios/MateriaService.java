package com.iric101v.practica.servicios;

import com.iric101v.practica.modelos.Materia;
import com.iric101v.practica.utils.Excepcion;

import java.util.List;

public interface MateriaService
{
    Materia getMateriaById(Integer id) throws Excepcion;


}