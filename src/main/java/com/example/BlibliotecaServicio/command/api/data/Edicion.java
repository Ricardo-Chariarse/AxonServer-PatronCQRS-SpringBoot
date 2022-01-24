package com.example.BlibliotecaServicio.command.api.data;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name="edicion")
public class Edicion {
    @Id()
    private String edicionId;
    private String libroId;
    private String editora;
    private String anio;
}
