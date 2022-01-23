package com.example.BlibliotecaServicio.command.api.events.libro;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LibroEliminarEvento {
    private String libroId;
}
