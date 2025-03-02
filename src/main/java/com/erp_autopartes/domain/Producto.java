package com.erp_autopartes.domain;

import java.math.BigDecimal;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codProducto;

    @NotBlank(message="Nombre obligatorio")
    @Column(nullable = false)
    private String nombre;

    @NotNull(message = "Precio obligatorio")
    @Positive(message = "Precio mayor a cero")
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal precioUnitario;

    @Min(value= 0, message = "Stock no puede ser negativo")
    @Column(nullable = false)
    private int stock;

    @ManyToOne
    @JoinColumn(name="codProveedor", nullable = false)
    private Proveedor proveedor;

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
        proveedor.getProductos().add(this);
    }

    @Override
    public String toString() {
        return this.nombre + " Precio: $" + this.precioUnitario;
    }
}
