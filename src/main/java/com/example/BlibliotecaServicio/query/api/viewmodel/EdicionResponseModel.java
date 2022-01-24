package com.example.BlibliotecaServicio.query.api.viewmodel;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EdicionResponseModel {
    private String edicionId;
    private String libroId;
    private String editora;
    private String anio;
}
