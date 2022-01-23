package com.example.BlibliotecaServicio.command.api.data;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "escritor")
public class Escritor {
    @Id
    private String escritroId;
    private String nombre;
    private String apellidos;
    private Integer numeroObras;
}
