package com.proyecto.biblioteca.useCase.impl;

import com.proyecto.biblioteca.model.Recurso;
import com.proyecto.biblioteca.repository.BibliotecaRepository;
import com.proyecto.biblioteca.useCase.IPrestarRecursoCasoUso;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@Service
@Validated
public class PrestarRecursoCasoUsoImpl implements IPrestarRecursoCasoUso {

    private final BibliotecaRepository bibliotecaRepository;

    public PrestarRecursoCasoUsoImpl(BibliotecaRepository bibliotecaRepository) {
        this.bibliotecaRepository = bibliotecaRepository;
    }

    @Override
    public Mono<String> prestarRecurso(String id) {
        Mono<Recurso> recursoMono = bibliotecaRepository.findById(id);
        return recursoMono.flatMap(recurso -> {
            if (recurso.isDisponible()){
                recurso.setFecha(LocalDate.now());
                recurso.setDisponible(false);
                return bibliotecaRepository
                        .save(recurso)
                        .thenReturn("Recurso prestado.");
            }
            return Mono.just("El recurso no se puede prestar, porque no esta disponible.");
        });
    }
}
