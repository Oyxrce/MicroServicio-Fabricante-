package com.example.fabricante_service.service;

import com.example.fabricante_service.model.Fabricante;
import com.example.fabricante_service.repository.FabricanteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FabricanteServiceImpl implements FabricanteService {
    
    private final FabricanteRepository repository;
    
    @Override
    @Transactional
    public Fabricante crear(Fabricante fabricante) {
        if (repository.existsByNombre(fabricante.getNombre())) {
            throw new RuntimeException("Fabricante ya existe: " + fabricante.getNombre());
        }
        return repository.save(fabricante);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Fabricante> obtenerTodos() {
        return repository.findAll();
    }
    
    @Override
    @Transactional(readOnly = true)
    public Fabricante obtenerPorId(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Fabricante no encontrado: " + id));
    }
    
    @Override
    @Transactional
    public Fabricante actualizar(Long id, Fabricante fabricante) {
        Fabricante existe = obtenerPorId(id);
        if (!existe.getNombre().equals(fabricante.getNombre()) 
            && repository.existsByNombre(fabricante.getNombre())) {
            throw new RuntimeException("Nombre ya existe: " + fabricante.getNombre());
        }
        existe.setNombre(fabricante.getNombre());
        return repository.save(existe);
    }
    
    @Override
    @Transactional
    public void eliminar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Fabricante no encontrado: " + id);
        }
        repository.deleteById(id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Fabricante> buscarPorNombre(String nombre) {
        return repository.findByNombreContainingIgnoreCase(nombre);
    }
}
