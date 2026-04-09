package com.QuickOrder.gestion.pedidos.repository;

import com.QuickOrder.gestion.pedidos.model.Incidencia;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class IncidenciaRepository {

    private List<Incidencia> baseDeDatos = new ArrayList<>();

    //Empiezo el contador en 1
    private Long contadorId = 1L; // Modificado a Long [cite: 1, 22]

    //C
    public Incidencia crear(Incidencia nuevaIncidencia) {
        nuevaIncidencia.setId(contadorId);
        contadorId++; //Cada nueva incidencia hago que se aumente en 1 el contador de ids
        baseDeDatos.add(nuevaIncidencia);
        return nuevaIncidencia;
    }


    //R
    public List<Incidencia> obtenerTodos() {
        return baseDeDatos;
    }


    //U
    public Incidencia actualizar(Incidencia incidenciaActualizada) {

        Long idBuscado = incidenciaActualizada.getId(); // Modificado a Long

        for (int i = 0; i < baseDeDatos.size(); i++) { //hago un for para recorrer la lista de mi base de datos
            Incidencia idActual = baseDeDatos.get(i); //a cada elemento que mi for recorrera, le mirare el id

            if (idActual.getId().equals(idBuscado)) { // Modificado a .equals() para comparar objetos Long
                baseDeDatos.set(i, incidenciaActualizada); //Si estos ids son iguales, le hago un set a mi base de datos y le indico el indice que quiero cambiar y que quiero agregar, lo cual sera la nueva incidenciaActualizada
                return incidenciaActualizada;
            }
        }
        return null;
    }


    //D
    public boolean eliminar(Long id) { // Modificado a Long
        return baseDeDatos.removeIf(incidencia -> incidencia.getId().equals(id)); // Modificado a .equals()
        //A mi base de datos le hago un remoIf, donde tendre una varaible temporal, la cual hara que tome cada incidencia dentro de la base de datos
        //y le hare un getId para compararlo con el id a eliminar, si esta no es igual a la que quiero eliminar, seguira con la siguiente
    }
}