package com.QuickOrder.gestion.pedidos.service;

import com.QuickOrder.gestion.pedidos.model.Estado;
import com.QuickOrder.gestion.pedidos.model.Incidencia;
import com.QuickOrder.gestion.pedidos.repository.IncidenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Service
public class IncidenciaService {

    @Autowired
    private IncidenciaRepository incidenciaRepository; //Conecto mi repository a mi service y lo llamare incidenciaRepository para utilizarlo aqui

    //C
    public Incidencia crear(Incidencia nuevaIncidencia) {
        if (nuevaIncidencia.getNombreCliente() == null || nuevaIncidencia.getNombreCliente().isEmpty()) { //Verifico si el nombre esta vacio, usare un throw new con el argumento correspondiente
            throw new IllegalArgumentException("El nombre no puede estar vacio");
        }

        if (nuevaIncidencia.getMontoTotal() == null || nuevaIncidencia.getMontoTotal() <= 0) { //Hago que hice con el nombre, pero esta vez con el monto
            throw new IllegalArgumentException("El monto total debe ser mayor a cero");
        }

        nuevaIncidencia.setFechaPedido(LocalDate.now()); //Uso un set en la fecha de la incidencia y luego LocalDate.now para cambiarle la fecha a la que corresponde
        return incidenciaRepository.crear(nuevaIncidencia); //Utilizo mi metodo anteriormente creado en el repository
    }

    //R
    public List<Incidencia> obtenerTodas() {
        return incidenciaRepository.obtenerTodos(); //Nuevamente utilizo mi metodo anteriormente creado en el repository
    }

    //U
    public Incidencia actualizar(Incidencia incidenciaActualizada) {
        return incidenciaRepository.actualizar(incidenciaActualizada); //Nuevamente utilizo mi metodo anteriormente creado en el repository
    }

    //D
    public boolean eliminar(Long id) { // Modificado a Long
        return incidenciaRepository.eliminar(id); //Nuevamente utilizo mi metodo anteriormente creado en el repository
    }


    public List<Incidencia> buscarPorEstado(Estado estado) {
        List<Incidencia> filtradas = new ArrayList<>(); //Creo una lista vacia dondeguardare los resultados
        List<Incidencia> todas = incidenciaRepository.obtenerTodos(); //Obtengotodo lo que hay en el repository

        for (Incidencia p : todas) { //Hago un for para recorrer la lista
            if (p.getEstado() == estado) { //Si el estado del pedido coincide con el buscado lo agregare a la lista
                filtradas.add(p);
            }
        }
        return filtradas; //Hago un return de lo que se encontro y agrego a la lista que cree antes
    }

    public Incidencia buscarPorId(Long id) { // Modificado a Long
        List<Incidencia> todas = incidenciaRepository.obtenerTodos(); //Creo una nueva lista de tipo incidencia y esta usara el metoro de obtenerTodos para llenarla
        for (Incidencia i : todas) { //Le obtengo el id a la que mi for tenga en la mano y la comparo con el id que quiero buscar
            if (i.getId().equals(id)) { // Modificado a .equals()
                return i; //Retornara el id y si no existe, un null
            }
        }
        return null;
    }

}