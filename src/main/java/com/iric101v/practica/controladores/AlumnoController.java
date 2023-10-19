package com.iric101v.practica.controladores;

import com.iric101v.practica.modelos.Alumno;
import com.iric101v.practica.servicios.AlumnoService;
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
@RequestMapping("/alumno")
public class AlumnoController {

    @Autowired
    AlumnoService alumnoService;


    @Autowired
    private HttpServletRequest request;

    @GetMapping("/{matricula}")
    @ApiOperation(value = "Obtiene los datos del Alumno buscandolo por Matricula")
    public ResponseEntity<Respuesta<Alumno>> buscarAlumnoPorMatricula (@PathVariable  Integer matricula)
    {
        String nombreDelEndpoint=request.getRequestURI();
        try
        {
            Alumno alumno = alumnoService.getAlumnoByMatricula(matricula);
            if(alumno!=null)
                return ResponseEntity.ok(new Respuesta<Alumno>(alumno,1,"",nombreDelEndpoint));
            else
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Respuesta<Alumno>(null,0,"No existe ningun registro en la base de datos de alumnos que coincida con la matricula '"+matricula+"'",nombreDelEndpoint));
        }
        catch (Excepcion e)
        {
            return ResponseEntity.status(e.getTipo()).body(new Respuesta<Alumno>(null,0,e.getMessage(),nombreDelEndpoint));
        }
    }
}
