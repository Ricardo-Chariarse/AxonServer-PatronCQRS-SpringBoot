package com.example.BlibliotecaServicio.command.api.controller;


import com.example.BlibliotecaServicio.command.api.commands.libro.ActualizarLibroCommand;
import com.example.BlibliotecaServicio.command.api.commands.libro.CrearLibroCommand;
import com.example.BlibliotecaServicio.command.api.commands.libro.EliminarLibroCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/libros")
public class LibroCommandController {

    private CommandGateway commandGateway;

    public LibroCommandController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping("/add")
    public String addLibro(@RequestBody CrearLibroCommand command){

//        CrearLibroCommand crearLibroCommand =
//                CrearLibroCommand.builder()
//                        .libroId(UUID.randomUUID().toString())
//                        .nombre(libroRestModel.getNombre())
//                        .autor(libroRestModel.getAutor())
//                        .precio(libroRestModel.getPrecio())
//                        .ediciones(libroRestModel.getEdiciones())
//                        .build();
        command.setLibroId(UUID.randomUUID().toString());
        String result = commandGateway.sendAndWait(command);
        return result;
    }
    @PostMapping("/update")
    public String updateLibro(@RequestBody ActualizarLibroCommand command){
        String result = commandGateway.sendAndWait(command);
        return result;
    }
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteLibro(@PathVariable("libroId") String id){
//        EliminarLibroCommand eliminarLibroCommand =
//                EliminarLibroCommand.builder()
//                        .libroId(libroEliminarModel.getLibroId())
//                        .build();
        var command = new  EliminarLibroCommand();
        command.setLibroId(id);
        String result = commandGateway.sendAndWait(command);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}

