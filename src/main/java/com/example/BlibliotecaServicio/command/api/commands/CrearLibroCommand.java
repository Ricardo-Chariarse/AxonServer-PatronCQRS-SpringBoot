package com.example.BlibliotecaServicio.command.api.commands;


import com.example.BlibliotecaServicio.command.api.model.Ediciones;
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
    private ArrayList<Ediciones> ediciones;
}
