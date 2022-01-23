package com.example.BlibliotecaServicio.command.api.controller;


import com.example.BlibliotecaServicio.command.api.commands.CrearEscritorCommand;
import com.example.BlibliotecaServicio.command.api.model.EscritorRestModel;
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
    public String AddEscritorCommand(@RequestBody EscritorRestModel escritorRestModel){
        CrearEscritorCommand crearEscritorCommand = CrearEscritorCommand
                .builder()
                .escritroId(UUID.randomUUID().toString())
                .nombre(escritorRestModel.getNombre())
                .apellidos(escritorRestModel.getApellidos())
                .numeroObras(escritorRestModel.getNumeroObras())
                .build();
        String result = commandGateway.sendAndWait(crearEscritorCommand);
        return result;
    }


}
