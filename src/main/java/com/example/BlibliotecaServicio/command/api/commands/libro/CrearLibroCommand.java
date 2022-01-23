package com.example.BlibliotecaServicio.command.api.commands.libro;


import com.example.BlibliotecaServicio.command.api.commands.edicion.CrearEdicionCommand;
import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.math.BigDecimal;
import java.util.ArrayList;

@Data
@Builder
public class CrearLibroCommand {

    @TargetAggregateIdentifier
    private String libroId;
    public String nombre;
    public String autor;
    public BigDecimal precio;
    private ArrayList<CrearEdicionCommand> ediciones;
}
