package com.example.BlibliotecaServicio.query.api.viewmodel;


import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class LibroRequestModel {
    private String libroId;
    public String nombre;
    public String autor;
    public BigDecimal precio;
}
