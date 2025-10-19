package com.example.fabricante_service.service;

import com.example.fabricante_service.model.Fabricante;
import java.util.List;

public interface FabricanteService {
    Fabricante crear(Fabricante fabricante);
    List<Fabricante> obtenerTodos();
    Fabricante obtenerPorId(Long id);
    Fabricante actualizar(Long id, Fabricante fabricante);
    void eliminar(Long id);
    List<Fabricante> buscarPorNombre(String nombre);
}