package com.example.fabricante_service.repository;

import com.example.fabricante_service.model.Fabricante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface FabricanteRepository extends JpaRepository<Fabricante, Long> {
    Optional<Fabricante> findByNombre(String nombre);
    boolean existsByNombre(String nombre);
    List<Fabricante> findByNombreContainingIgnoreCase(String nombre);
}