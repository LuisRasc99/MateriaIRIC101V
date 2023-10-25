package com.iric101v.practica.controladores;

import com.iric101v.practica.modelos.Materia;
import com.iric101v.practica.servicios.MateriaService;
import com.iric101v.practica.utils.Excepcion;
import com.iric101v.practica.utils.Respuesta;
import io.swagger.annotations.ApiOperation;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@CrossOrigin
@RequestMapping("/materia")
public class MateriaController {

    @Autowired
    MateriaService materiaService;


    @Autowired
    private HttpServletRequest request;

    @GetMapping("/{id}")
    @ApiOperation(value = "Obtiene los datos de la Materia buscandola por ID")
    public ResponseEntity<Respuesta<Materia>> buscarMateriaporId (@PathVariable Integer id)
    {
        String nombreDelEndpoint=request.getRequestURI();
        try
        {
            Materia materia = materiaService.getMateriaById(id);
            if(materia!=null)
                return ResponseEntity.ok(new Respuesta<Materia>(materia,1,"",nombreDelEndpoint));
            else
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Respuesta<Materia>(null,0,"No existe ningun registro en la base de datos de materia que coincida con el nombre '"+id+"'",nombreDelEndpoint));
        }
        catch (Excepcion e)
        {
            return ResponseEntity.status(e.getTipo()).body(new Respuesta<Materia>(null,0,e.getMessage(),nombreDelEndpoint));
        }
    }
}
