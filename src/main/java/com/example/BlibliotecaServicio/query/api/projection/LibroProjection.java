package com.example.BlibliotecaServicio.query.api.projection;

import com.example.BlibliotecaServicio.command.api.data.Libro;
import com.example.BlibliotecaServicio.command.api.data.LibroRepositorio;
import com.example.BlibliotecaServicio.query.api.querys.ObtenerLibroQuery;
import com.example.BlibliotecaServicio.query.api.querys.ObtenerLibrosQuery;
import com.example.BlibliotecaServicio.query.api.viewmodel.LibroRequestModel;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class LibroProjection {

    @Resource
    private LibroRepositorio libroRepositorio;

    @QueryHandler
    public List<LibroRequestModel> handle(ObtenerLibrosQuery query){
        List<Libro> libros = libroRepositorio.findAll();
        List<LibroRequestModel> libroRequestModels =
                libros.stream().map(libro -> LibroRequestModel.builder()
                        .libroId(libro.getLibroId())
                        .autor(libro.getAutor())
                        .nombre(libro.getNombre())
                        .precio(libro.getPrecio())
                        .build()
                ).collect(Collectors.toList());
        return libroRequestModels;
    }

    @QueryHandler
    public Optional<LibroRequestModel> handle(ObtenerLibroQuery query){
        String libroId = query.getLibroId();
        Optional<Libro> libros = libroRepositorio.findById(libroId);
        return libros.map(libro -> LibroRequestModel.builder()
                        .libroId(libro.getLibroId())
                        .autor(libro.getAutor())
                        .nombre(libro.getNombre())
                        .precio(libro.getPrecio())
                        .build()
                );
    }

}
