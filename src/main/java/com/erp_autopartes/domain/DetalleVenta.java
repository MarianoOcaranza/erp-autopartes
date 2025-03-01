package com.erp_autopartes.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetalleVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idDetalle;

    @ManyToOne
    @JoinColumn(name="idVenta", nullable = false)
    private Venta venta;

    @ManyToOne
    @JoinColumn(name="codProducto", nullable = false)
    private Producto producto;

    @Min(value = 1, message = "La cantidad debe ser mayor a cero")
    private int cantidad;

}
