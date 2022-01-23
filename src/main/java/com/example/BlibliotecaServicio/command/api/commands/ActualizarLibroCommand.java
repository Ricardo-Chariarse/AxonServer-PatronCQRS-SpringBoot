package com.example.BlibliotecaServicio.command.api.commands;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.math.BigDecimal;

@Data
@Builder
public class ActualizarLibroCommand {
    @TargetAggregateIdentifier
    private String libroId;
    public String nombre;
    public String autor;
    public BigDecimal precio;
}
