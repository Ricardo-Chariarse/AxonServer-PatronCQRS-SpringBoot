package com.example.BlibliotecaServicio.command.api.aggregate;

import com.example.BlibliotecaServicio.command.api.commands.edicion.ActualizarEdicionCommand;
import com.example.BlibliotecaServicio.command.api.commands.edicion.CrearEdicionCommand;
import com.example.BlibliotecaServicio.command.api.events.edicion.EdicionActualizarEvento;
import com.example.BlibliotecaServicio.command.api.events.edicion.EdicionCrearEvento;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.util.UUID;

@Aggregate
public class EdicionAggregate {
    @AggregateIdentifier
    private String _edicionId = UUID.randomUUID().toString();

    private String edicionId;
    private String libroId;
    private String editora;
    private String anio;

    @CommandHandler
    public EdicionAggregate(CrearEdicionCommand crearEdicionCommand){
        EdicionCrearEvento edicionCrearEvento = new EdicionCrearEvento();
        BeanUtils.copyProperties(crearEdicionCommand,edicionCrearEvento);
        AggregateLifecycle.apply(edicionCrearEvento);
    }
    @CommandHandler
    public EdicionAggregate(ActualizarEdicionCommand actualizarEdicionCommand){
        EdicionActualizarEvento edicionActualizarEvento = new EdicionActualizarEvento();
        BeanUtils.copyProperties(actualizarEdicionCommand,edicionActualizarEvento);
        AggregateLifecycle.apply(edicionActualizarEvento);
    }
    @EventSourcingHandler
    public void on(CrearEdicionCommand crearEdicionCommand){
        this.edicionId = crearEdicionCommand.getEdicionId();
        this.libroId = crearEdicionCommand.getLibroId();
        this.anio = crearEdicionCommand.getAnio();
        this.editora = crearEdicionCommand.getEditora();
    }
    @EventSourcingHandler
    public void on(ActualizarEdicionCommand actualizarEdicionCommand){
        this.edicionId = actualizarEdicionCommand.getEdicionId();
        this.libroId = actualizarEdicionCommand.getLibroId();
        this.anio = actualizarEdicionCommand.getAnio();
        this.editora = actualizarEdicionCommand.getEditora();
    }

}
