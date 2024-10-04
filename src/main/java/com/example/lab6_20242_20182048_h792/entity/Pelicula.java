package com.example.lab6_20242_20182048_h792.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "peliculas")
@Getter
@Setter
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "peliculaId", nullable = false)
    private int peliculaId;

    @NotBlank(message = "El título es obligatorio")
    @Size(min = 3, max = 100, message = "El título debe tener entre 3 y 100 caracteres")
    private String titulo;

    @NotNull(message = "La fecha de estreno es obligatoria")
    @PastOrPresent(message = "La fecha de estreno debe ser pasada o presente")
    private Date fechaEstreno;

    @NotNull(message = "La duración en minutos es obligatoria")
    @Positive(message = "La duración debe ser un número positivo")
    private Integer duracionMinutos;
}
