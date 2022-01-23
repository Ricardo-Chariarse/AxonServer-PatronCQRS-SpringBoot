package com.example.BlibliotecaServicio.command.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LibroEliminarModel {
    private String libroId;
}
