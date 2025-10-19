package com.example.fabricante_service.controller;

import com.example.fabricante_service.model.Fabricante;
import com.example.fabricante_service.service.FabricanteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/fabricantes")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class FabricanteController {
    
    private final FabricanteService service;
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Fabricante crear(@Valid @RequestBody Fabricante fabricante) {
        return service.crear(fabricante);
    }
    
    @GetMapping
    public List<Fabricante> obtenerTodos() {
        return service.obtenerTodos();
    }
    
    @GetMapping("/{id}")
    public Fabricante obtenerPorId(@PathVariable Long id) {
        return service.obtenerPorId(id);
    }
    
    @GetMapping("/buscar/{nombre}")
    public List<Fabricante> buscarPorNombre(@PathVariable String nombre) {
        return service.buscarPorNombre(nombre);
    }
    
    @PutMapping("/{id}")
    public Fabricante actualizar(@PathVariable Long id, @Valid @RequestBody Fabricante fabricante) {
        return service.actualizar(id, fabricante);
    }
    
    @PatchMapping("/{id}")
    public Fabricante actualizarParcial(@PathVariable Long id, @RequestBody Fabricante fabricante) {
        return service.actualizar(id, fabricante);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}