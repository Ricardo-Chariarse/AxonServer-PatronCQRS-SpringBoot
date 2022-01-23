package com.example.BlibliotecaServicio.command.api.commands.edicion;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
public class CrearEdicionCommand {

    @TargetAggregateIdentifier
    private String edicionId;
    private String libroId;
    private String editora;
    private String anio;

}
