package com.example.BlibliotecaServicio.command.api.events;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EdicionCrearEvento {
    private String edicionId;
    private String libroId;
    private String editora;
    private String anio;
}
