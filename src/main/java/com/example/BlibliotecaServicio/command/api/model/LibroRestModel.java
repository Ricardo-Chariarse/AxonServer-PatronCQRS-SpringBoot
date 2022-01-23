package com.example.BlibliotecaServicio.command.api.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;

@Data
@Builder
public class LibroRestModel {
    private String nombre;
    private String autor;
    private BigDecimal precio;
    private ArrayList<Ediciones> ediciones;
}
