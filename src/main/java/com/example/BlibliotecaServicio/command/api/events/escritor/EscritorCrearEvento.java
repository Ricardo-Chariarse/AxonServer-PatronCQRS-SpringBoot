package com.example.BlibliotecaServicio.command.api.events.escritor;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EscritorCrearEvento {
    private String escritroId;
    private String nombre;
    private String apellidos;
    private Integer numeroObras;
}
