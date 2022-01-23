package com.example.BlibliotecaServicio.query.api.controller;


import com.example.BlibliotecaServicio.query.api.querys.ObtenerLibroQuery;
import com.example.BlibliotecaServicio.query.api.querys.ObtenerLibrosQuery;
import com.example.BlibliotecaServicio.query.api.viewmodel.LibroRequestModel;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/querylibro")
public class LibroQueryController {
    @Resource
    private QueryGateway queryGateway;

    @GetMapping("/obtenerLibros")
    private List<LibroRequestModel> obtenerLibros(){
        ObtenerLibrosQuery obtenerLibrosQuery = new ObtenerLibrosQuery();
        List<LibroRequestModel> libroRequestModels =
                queryGateway.query(obtenerLibrosQuery,
                                ResponseTypes.multipleInstancesOf(LibroRequestModel.class))
                                .join();
        return libroRequestModels;
    }
    @GetMapping("/obtenerLibro")
    private LibroRequestModel obtenerLibro(ObtenerLibroQuery obtenerLibrosQuery){
        LibroRequestModel libroRequestModels =
                queryGateway.query(obtenerLibrosQuery,
                                ResponseTypes.instanceOf(LibroRequestModel.class))
                        .join();
        return libroRequestModels;
    }

}
