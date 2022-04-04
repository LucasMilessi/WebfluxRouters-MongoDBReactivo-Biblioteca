package com.proyecto.biblioteca.useCase.impl;

import com.proyecto.biblioteca.model.Recurso;
import com.proyecto.biblioteca.repository.BibliotecaRepository;
import com.proyecto.biblioteca.useCase.IDisponibilidadRecursoUseCase;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
@Validated
public class DisponibilidadRecursoUseCaseImpl implements IDisponibilidadRecursoUseCase {

    private final BibliotecaRepository bibliotecaRepository;

    public DisponibilidadRecursoUseCaseImpl(BibliotecaRepository bibliotecaRepository) {
        this.bibliotecaRepository = bibliotecaRepository;
    }

    @Override
    public Mono<String> consultarDisponibilidad(String id) {

        if (Objects.isNull(id)){
            return Mono.empty();
        }
        Mono<Recurso> recurso = bibliotecaRepository.findById(id);

        return recurso.map(recurso1 ->
                recurso1.isDisponible() ? "El recurso se encuentra disponible para prestarlo" :
                        "El recurso no esta disponible, fue prestado en la fecha: " + recurso1.getFecha());
    }
}
