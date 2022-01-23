package com.example.BlibliotecaServicio.command.api.commands;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
public class ActualizarEdicionCommand {

    @TargetAggregateIdentifier
    private String edicionId;
    private String libroId;
    private String editora;
    private String anio;

}
