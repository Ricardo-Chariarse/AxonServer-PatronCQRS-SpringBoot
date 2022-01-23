package com.example.BlibliotecaServicio.command.api.events.libro;

import com.example.BlibliotecaServicio.command.api.commands.edicion.CrearEdicionCommand;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LibroCrearEvento {

    private String libroId;
    private String nombre;
    private String autor;
    private BigDecimal precio;
    private ArrayList<CrearEdicionCommand> ediciones;

}
