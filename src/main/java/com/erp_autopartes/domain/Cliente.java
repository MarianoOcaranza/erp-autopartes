package com.erp_autopartes.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    @Id
    @Column(nullable = false, unique = true)
    @NotNull(message = "DNI obligatorio")
    private long dniCliente;

    @Column(nullable = false)
    @NotNull(message = "Nombre obligatorio")
    private String nombre;

    @Column(nullable = false)
    @NotNull(message = "Apellido obligatorio")
    private String apellido;

    @Email
    @Column(nullable = false)
    @NotNull(message = "Email obligatorio")
    private String email;

    @Column(nullable = true)
    private String phone;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Venta> ventas = new ArrayList<>();
}
