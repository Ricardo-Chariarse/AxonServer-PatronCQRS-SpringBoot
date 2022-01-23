package com.example.BlibliotecaServicio.command.api.controller;

import com.example.BlibliotecaServicio.command.api.commands.ActualizarEdicionCommand;
import com.example.BlibliotecaServicio.command.api.commands.CrearEdicionCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;

@RestController
@RequestMapping("/edicion")
public class EdicionCommandController {

    @Resource
    private CommandGateway commandGateway;

    @PostMapping("/add")
    private String addEdicion(CrearEdicionCommand command){
        command.setEdicionId(UUID.randomUUID().toString());
        String result = commandGateway.sendAndWait(command);
        return result;
    }

    @PutMapping("/update")
    private String updateEdicion(ActualizarEdicionCommand command){
        String result = commandGateway.sendAndWait(command);
        return result;
    }

}
