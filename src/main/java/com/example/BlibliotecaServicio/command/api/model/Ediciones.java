package com.example.BlibliotecaServicio.command.api.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Ediciones {
    private String edicionId;
    private String libroId;
    private String editora;
    private String anio;
}
