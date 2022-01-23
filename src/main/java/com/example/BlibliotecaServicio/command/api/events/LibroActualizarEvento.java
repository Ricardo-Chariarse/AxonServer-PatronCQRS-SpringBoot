package com.example.BlibliotecaServicio.command.api.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LibroActualizarEvento {
    private String libroId;
    public String nombre;
    public String autor;
    public BigDecimal precio;
}
