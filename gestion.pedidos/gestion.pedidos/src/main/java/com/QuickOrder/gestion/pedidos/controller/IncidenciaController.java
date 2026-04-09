package com.QuickOrder.gestion.pedidos.controller;

import com.QuickOrder.gestion.pedidos.model.Estado;
import com.QuickOrder.gestion.pedidos.model.Incidencia;
import com.QuickOrder.gestion.pedidos.service.IncidenciaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos") //Defino mi ruta
public class IncidenciaController {

    @Autowired
    private IncidenciaService incidenciaService;


    //Endpoint para registrar un nuevo pedido
    @PostMapping //Para registrar un nuevo pedido
    public ResponseEntity<Incidencia> crear(@Valid @RequestBody Incidencia nuevaIncidencia) { //
        Incidencia creada = incidenciaService.crear(nuevaIncidencia);
        return ResponseEntity.status(HttpStatus.CREATED).body(creada); //Hago un return del pedido creado
    }


    //Endpoint para listar todos los pedidos registrados
    @GetMapping
    public ResponseEntity<List<Incidencia>> listarTodas() {
        return ResponseEntity.ok(incidenciaService.obtenerTodas()); //Retorno la lista de pedidos con un OK
    }


    //Endpoint para obtener un pedido en especifico por su id
    @GetMapping("/{id}")
    public ResponseEntity<Incidencia> buscarPorId(@PathVariable Long id) { // Modificado a Long [cite: 1, 44]
        Incidencia encontrada = incidenciaService.buscarPorId(id); //Llamo al service para que busque el pedido

        if (encontrada == null) { //Si no lo encuentro, retorno un notFound
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(encontrada); //Si lo encuentro, retorno un ok
    }


    //Endpoint para poder actualizar datos de algun pedido
    @PutMapping("/{id}")
    public ResponseEntity<Incidencia> actualizar(@PathVariable Long id, @Valid @RequestBody Incidencia incidenciaActualizada) { // Modificado a Long
        incidenciaActualizada.setId(id);
        Incidencia actualizada = incidenciaService.actualizar(incidenciaActualizada);

        if (actualizada == null) { //Comienzo a recorrer para ver si existe
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actualizada); //Hago un return del pedido eactualizado, si no existe hago un notfound
    }


    //Endpoint para eliminar un pedido del sistema
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) { // Modificado a Long [cite: 1, 44]
        boolean fueEliminada = incidenciaService.eliminar(id);
        if (fueEliminada) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        } //Dependiendo de si fue eliminada o no, le pongo un noContent o un notFound
    }

    //Un GetMapping para filtrar pedidos por su estado
    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<Incidencia>> buscarPorEstado(@PathVariable Estado estado) { //Como antes use el enum, el estado podra tener varios estados
        List<Incidencia> filtradas = incidenciaService.buscarPorEstado(estado);
        return ResponseEntity.ok(filtradas);
    }
}