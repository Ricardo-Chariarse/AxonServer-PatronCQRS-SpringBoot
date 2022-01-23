package com.example.BlibliotecaServicio.command.api.aggregate;

import com.example.BlibliotecaServicio.command.api.commands.edicion.CrearEdicionCommand;
import com.example.BlibliotecaServicio.command.api.commands.libro.ActualizarLibroCommand;
import com.example.BlibliotecaServicio.command.api.commands.libro.CrearLibroCommand;
import com.example.BlibliotecaServicio.command.api.commands.libro.EliminarLibroCommand;
import com.example.BlibliotecaServicio.command.api.events.libro.LibroActualizarEvento;
import com.example.BlibliotecaServicio.command.api.events.libro.LibroCrearEvento;
import com.example.BlibliotecaServicio.command.api.events.libro.LibroEliminarEvento;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.UUID;

@Aggregate
public class LibroAggregate {

    @AggregateIdentifier
    private String _libroId = UUID.randomUUID().toString();

    private String libroId;
    public String nombre;
    public String autor;
    public BigDecimal precio;
    private ArrayList<CrearEdicionCommand> ediciones;
    @CommandHandler
    public LibroAggregate(CrearLibroCommand crearLibroCommand){
        LibroCrearEvento libroCrearEvento = new LibroCrearEvento();

        BeanUtils.copyProperties(crearLibroCommand,libroCrearEvento);

        AggregateLifecycle.apply(libroCrearEvento);
    }
    @CommandHandler
    public LibroAggregate(ActualizarLibroCommand actualizarLibroCommand){
        LibroActualizarEvento libroActualizarEvento = new LibroActualizarEvento();

        BeanUtils.copyProperties(actualizarLibroCommand,libroActualizarEvento);

        AggregateLifecycle.apply(libroActualizarEvento);
    }
    @CommandHandler
    public LibroAggregate(EliminarLibroCommand eliminarLibroCommand){
        LibroEliminarEvento libroEliminarEvento = new LibroEliminarEvento();

        BeanUtils.copyProperties(eliminarLibroCommand,libroEliminarEvento);

        AggregateLifecycle.apply(libroEliminarEvento);
    }
    public LibroAggregate(){

    }
    @EventSourcingHandler
    public void on(LibroCrearEvento libroCrearEvento){
        this.libroId = libroCrearEvento.getLibroId();
        this.nombre = libroCrearEvento.getNombre();
        this.autor = libroCrearEvento.getAutor();
        this.precio = libroCrearEvento.getPrecio();
        this.ediciones = libroCrearEvento.getEdiciones();
    }
    @EventSourcingHandler
    public void on(ActualizarLibroCommand actualizarLibroCommand){
        this.libroId = actualizarLibroCommand.getLibroId();
        this.nombre = actualizarLibroCommand.getNombre();
        this.autor = actualizarLibroCommand.getAutor();
        this.precio = actualizarLibroCommand.getPrecio();
    }
    @EventSourcingHandler
    public void on(EliminarLibroCommand eliminarLibroCommand){
        this.libroId = eliminarLibroCommand.getLibroId();
    }
}
