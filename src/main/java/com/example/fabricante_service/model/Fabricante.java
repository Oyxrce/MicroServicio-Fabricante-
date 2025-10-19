package com.example.fabricante_service.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "fabricante")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Fabricante {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 100)
    @Column(nullable = false, unique = true, length = 100)
    private String nombre;
}