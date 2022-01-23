package com.example.BlibliotecaServicio.command.api.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EscritorRepositorio extends JpaRepository<Escritor,String> {
}
