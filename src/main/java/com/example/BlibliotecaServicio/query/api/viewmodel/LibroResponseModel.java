package com.example.BlibliotecaServicio.query.api.viewmodel;


import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class LibroResponseModel {
    private String libroId;
    public String nombre;
    public String autor;
    public BigDecimal precio;
}
