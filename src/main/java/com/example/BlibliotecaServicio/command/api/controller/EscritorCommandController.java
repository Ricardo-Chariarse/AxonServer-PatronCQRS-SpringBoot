package com.example.BlibliotecaServicio.command.api.controller;


import com.example.BlibliotecaServicio.command.api.commands.escritor.CrearEscritorCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/escritor")
public class EscritorCommandController {
    private CommandGateway commandGateway;

    public EscritorCommandController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping("/add")
    public String AddEscritorCommand(@RequestBody CrearEscritorCommand command){
        CrearEscritorCommand crearEscritorCommand = CrearEscritorCommand
                .builder()
                .escritroId(UUID.randomUUID().toString())
                .nombre(command.getNombre())
                .apellidos(command.getApellidos())
                .numeroObras(command.getNumeroObras())
                .build();
        String result = commandGateway.sendAndWait(crearEscritorCommand);
        return result;
    }


}
