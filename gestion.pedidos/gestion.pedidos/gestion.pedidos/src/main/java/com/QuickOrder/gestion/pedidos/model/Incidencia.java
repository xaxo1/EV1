package com.QuickOrder.gestion.pedidos.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Incidencia {

    @NotNull
    private int id;

    @NotBlank(message = "El nombre es obligatorio.")
    private String nombreCliente;

    @NotBlank(message = "La descripcion es obligatoria.")
    private String descripcion;

    @NotNull(message = "El estado es obligatorio.")
    private Estado estado;

    @NotNull(message = "El tipo de pedido es obligatorio.")
    private TipoPedido tipoPedido;

    @NotNull(message = "El monto es obligatorio.")
    private Double montoTotal;

    private LocalDate fechaPedido;


    //aqui no me tomaba el setId en repository asi que hice los getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public TipoPedido getTipoPedido() {
        return tipoPedido;
    }

    public void setTipoPedido(TipoPedido tipoPedido) {
        this.tipoPedido = tipoPedido;
    }

    public Double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(Double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public LocalDate getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDate fechaPedido) {
        this.fechaPedido = fechaPedido;
    }
}
