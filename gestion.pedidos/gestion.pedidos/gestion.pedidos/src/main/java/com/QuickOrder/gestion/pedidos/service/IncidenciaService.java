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
    public boolean eliminar(int id) {
        return incidenciaRepository.eliminar(id); //Nuevamente utilizo mi metodo anteriormente creado en el repository
    }



}
