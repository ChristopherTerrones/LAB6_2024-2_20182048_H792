package com.example.lab6_20242_20182048_h792.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Entity
@Table(name = "directores")
@Getter
@Setter
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "directorId", nullable = false)
    private int directorId;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 2, max = 100, message = " El nombre debe tener entre 2 y 100 caracteres")
    private String nombre;

    @NotNull(message = "El telefono es obligatorio")
    @Size(max = 9,min = 9,message = "El telefono debe tener 9 dígitos")
    private String telefono;

    @NotNull(message = "Seleccione la nacionalidad")
    private String nacionalidad;
}
