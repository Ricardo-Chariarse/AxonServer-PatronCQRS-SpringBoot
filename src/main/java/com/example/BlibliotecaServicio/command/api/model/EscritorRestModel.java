package com.example.BlibliotecaServicio.command.api.model;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EscritorRestModel {
    private String nombre;
    private String apellidos;
    private Integer numeroObras;
}
