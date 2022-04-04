package com.proyecto.biblioteca.useCase.impl;

import com.proyecto.biblioteca.mapper.RecursoMapper;
import com.proyecto.biblioteca.model.Recurso;
import com.proyecto.biblioteca.repository.BibliotecaRepository;
import com.proyecto.biblioteca.useCase.IDevolverRecursoUseCase;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class DevolverRecursoUseCaseImpl implements IDevolverRecursoUseCase {

    private final BibliotecaRepository bibliotecaRepository;
    private final RecursoMapper recursoMapper;
    private final ActualizarRecursoUseCaseImpl actualizarRecursoUseCase;

    public DevolverRecursoUseCaseImpl(BibliotecaRepository bibliotecaRepository, RecursoMapper recursoMapper, ActualizarRecursoUseCaseImpl actualizarRecursoUseCase) {
        this.bibliotecaRepository = bibliotecaRepository;
        this.recursoMapper = recursoMapper;
        this.actualizarRecursoUseCase = actualizarRecursoUseCase;
    }

    @Override
    public Mono<String> devolverRecurso(String id) {

        Mono<Recurso> recursoMono = bibliotecaRepository.findById(id);

        return recursoMono.flatMap(recurso -> {
            if (!recurso.isDisponible()){
                recurso.setDisponible(true);
                return bibliotecaRepository
                        .save(recurso)
                        .thenReturn("El recurso fue devuelto.");
            }
            return Mono.just("El recurso no se puede devolver porque no todavia no a sido prestado.");
        });
    }
}
