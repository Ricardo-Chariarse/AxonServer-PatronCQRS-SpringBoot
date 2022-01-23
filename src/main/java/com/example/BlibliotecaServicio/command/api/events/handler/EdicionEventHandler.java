package com.example.BlibliotecaServicio.command.api.events.handler;


import com.example.BlibliotecaServicio.command.api.data.Edicion;
import com.example.BlibliotecaServicio.command.api.data.EdicionRepositorio;
import com.example.BlibliotecaServicio.command.api.data.LibroRepositorio;
import com.example.BlibliotecaServicio.command.api.events.edicion.EdicionActualizarEvento;
import com.example.BlibliotecaServicio.command.api.events.edicion.EdicionCrearEvento;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@ProcessingGroup("edicion")
public class EdicionEventHandler {

    @Resource
    private EdicionRepositorio edicionRepositorio;

    @Resource
    private LibroRepositorio libroRepositorio;

    @EventHandler
    public void on(EdicionCrearEvento evento){
        Edicion edicion = new Edicion();
        boolean existe = libroRepositorio.existsById(evento.getLibroId());
        if(existe){
            BeanUtils.copyProperties(evento,edicion);
            edicionRepositorio.save(edicion);
        }
    }
    @EventHandler
    public void on(EdicionActualizarEvento evento){
        boolean existe = libroRepositorio.existsById(evento.getLibroId());
        if(existe){
            boolean existeEdicion = edicionRepositorio.existsById(evento.getEdicionId());
            if(existeEdicion) {
                var edicion = edicionRepositorio.getById(evento.getEdicionId());
                edicion.setEditora(evento.getEditora());
                edicion.setLibroId(evento.getLibroId());
                edicion.setAnio(evento.getAnio());
                edicionRepositorio.save(edicion);
            }
        }
    }

}
