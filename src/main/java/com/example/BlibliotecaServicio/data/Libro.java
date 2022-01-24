package com.example.BlibliotecaServicio.data;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@Entity
@Table(name= "libro")
public class Libro {
    @Id
    private String libroId;
    public String nombre;
    public String autor;
    public BigDecimal precio;
}
