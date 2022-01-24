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
        command.setLibroId(UUID.randomUUID().toString());
        String result = commandGateway.sendAndWait(command);
        return result;
    }
    @PutMapping("/update")
    public String updateLibro(@RequestBody ActualizarLibroCommand command){
        String result = commandGateway.sendAndWait(command);
        return result;
    }
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteLibro(@RequestBody EliminarLibroCommand command){
        String result = commandGateway.sendAndWait(command);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}

