package com.example.BlibliotecaServicio.query.api.controller;


import com.example.BlibliotecaServicio.query.api.querys.ObtenerLibroQuery;
import com.example.BlibliotecaServicio.query.api.querys.ObtenerLibrosQuery;
import com.example.BlibliotecaServicio.query.api.viewmodel.LibroResponseModel;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/querylibro")
public class LibroQueryController {
    @Resource
    private QueryGateway queryGateway;

    @GetMapping("/obtenerLibros")
    private List<LibroResponseModel> obtenerLibros(){
        ObtenerLibrosQuery obtenerLibrosQuery = new ObtenerLibrosQuery();
        List<LibroResponseModel> libroRequestModels =
                queryGateway.query(obtenerLibrosQuery,
                                ResponseTypes.multipleInstancesOf(LibroResponseModel.class))
                                .join();
        return libroRequestModels;
    }
    @GetMapping("/obtenerLibro")
    private LibroResponseModel obtenerLibro(ObtenerLibroQuery obtenerLibrosQuery){
        LibroResponseModel libroRequestModels =
                queryGateway.query(obtenerLibrosQuery,
                                ResponseTypes.instanceOf(LibroResponseModel.class))
                        .join();
        return libroRequestModels;
    }

}
