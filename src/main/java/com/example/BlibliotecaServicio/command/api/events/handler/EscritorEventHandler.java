package com.example.BlibliotecaServicio.command.api.events.handler;


import com.example.BlibliotecaServicio.data.Escritor;
import com.example.BlibliotecaServicio.data.EscritorRepositorio;
import com.example.BlibliotecaServicio.command.api.events.escritor.EscritorCrearEvento;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@ProcessingGroup("escritor")
public class EscritorEventHandler {

    private EscritorRepositorio escritorRepositorio;

    public EscritorEventHandler(EscritorRepositorio escritorRepositorio){
        this.escritorRepositorio = escritorRepositorio;
    }
    @EventHandler
    public void on(EscritorCrearEvento evento){
        Escritor escritor = new Escritor();
        BeanUtils.copyProperties(evento, escritor);
        escritorRepositorio.save(escritor);
    }
}
