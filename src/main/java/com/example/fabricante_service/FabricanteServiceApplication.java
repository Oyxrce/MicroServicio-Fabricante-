package com.example.fabricante_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FabricanteServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(FabricanteServiceApplication.class, args);
        System.out.println("\n" + "=".repeat(50));
        System.out.println(" MicroServicio Fabricante Operativo - Puerto 8083");
        System.out.println(" http://localhost:8083/api/fabricantes");
        System.out.println("=".repeat(50) + "\n");
    }
}