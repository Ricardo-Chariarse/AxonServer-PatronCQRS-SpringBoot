package com.example.BlibliotecaServicio.query.api.projection;


import com.example.BlibliotecaServicio.command.api.data.Edicion;
import com.example.BlibliotecaServicio.command.api.data.EdicionRepositorio;
import com.example.BlibliotecaServicio.command.api.data.Libro;
import com.example.BlibliotecaServicio.command.api.data.LibroRepositorio;
import com.example.BlibliotecaServicio.query.api.querys.ObtenerEdicionesLibroQuery;
import com.example.BlibliotecaServicio.query.api.querys.ObtenerEdicionesQuery;
import com.example.BlibliotecaServicio.query.api.querys.ObtenerLibrosQuery;
import com.example.BlibliotecaServicio.query.api.viewmodel.EdicionResponseModel;
import com.example.BlibliotecaServicio.query.api.viewmodel.LibroResponseModel;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class EdicionProjection {

    @Resource
    private EdicionRepositorio edicionRepositorio;

    @Resource
    private LibroRepositorio libroRepositorio;

    @QueryHandler
    public List<EdicionResponseModel> handle(ObtenerEdicionesQuery query){
        List<Edicion> edicions = edicionRepositorio.findAll();
        List<EdicionResponseModel> edicionResponseModels =
                edicions.stream().map(edicion -> EdicionResponseModel.builder()
                        .libroId(edicion.getLibroId())
                        .anio(edicion.getAnio())
                        .edicionId(edicion.getEdicionId())
                        .editora(edicion.getEditora())
                        .build()
                ).collect(Collectors.toList());
        return edicionResponseModels;
    }

    @QueryHandler
    public List<EdicionResponseModel> handle(ObtenerEdicionesLibroQuery query){
        String libroId = query.getLibroId();
        List<Edicion> edicions1 = edicionRepositorio.findAll();
        List<Edicion> edicions = new ArrayList<Edicion>();
        for (var item: edicions1) {
            String libroId2 = item.getLibroId();
            if(libroId2.equals(libroId)){
                edicions.add(item);
            }
        }
        List<EdicionResponseModel> edicionResponseModel =
                edicions.stream().map(edicion -> EdicionResponseModel.builder()
                        .anio(edicion.getAnio())
                        .editora(edicion.getEditora())
                        .edicionId(edicion.getEdicionId())
                        .libroId(edicion.getLibroId())
                        .build()
                ).collect(Collectors.toList());
        return edicionResponseModel;

    }

}
