package com.erp_autopartes.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codProveedor;

    @NotNull(message = "El cuit no debe ser nulo")
    @Pattern(regexp = "[0-9]{2}-[0-9]{8}-[0-9]{1}", message = "CUIT invalido")
    private String CUIT;

    @NotNull(message = "Nombre obligatorio")
    private String nombre;

    @NotNull(message = "Direccion obligatoria")
    private String direccion;

    @Email
    @NotNull(message="Email obligatorio")
    private String email;

    @OneToMany(mappedBy = "proveedor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Producto> productos = new ArrayList<>();

    public void agregarProducto(Producto producto) {
        this.productos.add(producto);
        producto.setProveedor(this);
    }

    public void eliminarProducto(Producto producto) {
        this.productos.remove(producto);
        producto.setProveedor(null);
    }
}
