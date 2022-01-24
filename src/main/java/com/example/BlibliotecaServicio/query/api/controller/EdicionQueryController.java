package com.example.BlibliotecaServicio.query.api.controller;


import com.example.BlibliotecaServicio.query.api.querys.ObtenerEdicionesLibroQuery;
import com.example.BlibliotecaServicio.query.api.querys.ObtenerEdicionesQuery;
import com.example.BlibliotecaServicio.query.api.querys.ObtenerLibrosQuery;
import com.example.BlibliotecaServicio.query.api.viewmodel.EdicionResponseModel;
import com.example.BlibliotecaServicio.query.api.viewmodel.LibroResponseModel;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/queryEdicion")
public class EdicionQueryController {

    @Resource
    private QueryGateway queryGateway;

    @GetMapping("/obtenerEdiciones")
    private List<EdicionResponseModel> obtenerEdiciones(){
        ObtenerEdicionesQuery obtenerEdicionesQuery = new ObtenerEdicionesQuery();
        List<EdicionResponseModel> edicionResponseModels =
                queryGateway.query(obtenerEdicionesQuery,
                                ResponseTypes.multipleInstancesOf(EdicionResponseModel.class))
                        .join();
        return edicionResponseModels;
    }

    @GetMapping("/obtenerEdicionesLibro")
    private List<EdicionResponseModel> obtenerEdicionesLibro(ObtenerEdicionesLibroQuery query){
        List<EdicionResponseModel> edicionResponseModel =
                queryGateway.query(query,
                        ResponseTypes.multipleInstancesOf(EdicionResponseModel.class))
                        .join();
        return edicionResponseModel;
    }

}
