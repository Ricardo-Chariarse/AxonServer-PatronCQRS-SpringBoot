package com.example.BlibliotecaServicio.command.api.commands;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.io.Serializable;

@Getter
@Setter
public class EliminarLibroCommand implements Serializable {
    @TargetAggregateIdentifier
    private String libroId;
}
