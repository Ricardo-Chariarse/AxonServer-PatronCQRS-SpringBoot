package com.example.BlibliotecaServicio.command.api.events;


import com.example.BlibliotecaServicio.command.api.data.Escritor;
import com.example.BlibliotecaServicio.command.api.data.EscritorRepositorio;
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
