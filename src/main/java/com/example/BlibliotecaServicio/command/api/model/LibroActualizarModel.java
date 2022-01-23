package com.example.BlibliotecaServicio.command.api.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class LibroActualizarModel {
    private String libroId;
    private String nombre;
    private String autor;
    private BigDecimal precio;
}
