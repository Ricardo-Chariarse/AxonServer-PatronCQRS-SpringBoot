package com.example.BlibliotecaServicio.command.api.events.handler;

import com.example.BlibliotecaServicio.command.api.commands.edicion.CrearEdicionCommand;
import com.example.BlibliotecaServicio.command.api.data.Edicion;
import com.example.BlibliotecaServicio.command.api.data.EdicionRepositorio;
import com.example.BlibliotecaServicio.command.api.data.Libro;
import com.example.BlibliotecaServicio.command.api.data.LibroRepositorio;
import com.example.BlibliotecaServicio.command.api.events.libro.LibroActualizarEvento;
import com.example.BlibliotecaServicio.command.api.events.libro.LibroCrearEvento;
import com.example.BlibliotecaServicio.command.api.events.libro.LibroEliminarEvento;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.UUID;

@Component
@ProcessingGroup("libro")
public class LibroEventHandler {
    @Resource
    private LibroRepositorio libroRepositorio;
    @Resource
    private EdicionRepositorio edicionRepositorio;



    @EventHandler
    public void on(LibroCrearEvento evento) {
        Libro libro = new Libro();
        if(evento.getEdiciones() != null){
            ArrayList<CrearEdicionCommand> ediciones = evento.getEdiciones();
            for (CrearEdicionCommand item:ediciones) {
                Edicion edicion = new Edicion();
                item.setLibroId(evento.getLibroId());
                BeanUtils.copyProperties(item,edicion);
                edicion.setEdicionId(UUID.randomUUID().toString());
                if(edicion.getEditora() != null){
                    edicionRepositorio.save(edicion);
                }
            }
            BeanUtils.copyProperties(evento,libro);
            libroRepositorio.save(libro);
        }
    }
    @EventHandler
    public void on(LibroActualizarEvento evento){
        boolean existe = libroRepositorio.existsById(evento.getLibroId());
        if(existe){
            var libro = libroRepositorio.getById(evento.getLibroId());
            libro.setPrecio(evento.getPrecio());
            libro.setNombre(evento.getNombre());
            libro.setAutor(evento.getAutor());
            libroRepositorio.save(libro);
        }
    }
    @EventHandler
    public void on(LibroEliminarEvento evento){
        boolean existe = libroRepositorio.existsById(evento.getLibroId());
        if(existe){
            libroRepositorio.deleteById(evento.getLibroId());
        }
    }

}
