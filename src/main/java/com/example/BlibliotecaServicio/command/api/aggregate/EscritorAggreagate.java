package com.example.BlibliotecaServicio.command.api.aggregate;

import com.example.BlibliotecaServicio.command.api.commands.escritor.CrearEscritorCommand;
import com.example.BlibliotecaServicio.command.api.events.escritor.EscritorCrearEvento;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
public class EscritorAggreagate {
    @AggregateIdentifier
    private String escritroId;
    private String nombre;
    private String apellidos;
    private Integer numeroObras;

    @CommandHandler
    public EscritorAggreagate (CrearEscritorCommand crearEscritorCommand){
        EscritorCrearEvento escritorCrearEvento = new EscritorCrearEvento();
        BeanUtils.copyProperties(crearEscritorCommand, escritorCrearEvento);
        AggregateLifecycle.apply(escritorCrearEvento);
    }
    public EscritorAggreagate(){

    }
    @EventSourcingHandler
    public void on(EscritorCrearEvento escritorCrearEvento){
        this.escritroId = escritorCrearEvento.getEscritroId();
        this.nombre = escritorCrearEvento.getNombre();
        this.apellidos = escritorCrearEvento.getApellidos();
        this.numeroObras = escritorCrearEvento.getNumeroObras();
    }
}
