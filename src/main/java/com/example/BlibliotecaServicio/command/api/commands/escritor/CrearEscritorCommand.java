package com.example.BlibliotecaServicio.command.api.commands.escritor;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
public class CrearEscritorCommand {

    @TargetAggregateIdentifier
    private String escritroId;
    private String nombre;
    private String apellidos;
    private Integer numeroObras;
}
