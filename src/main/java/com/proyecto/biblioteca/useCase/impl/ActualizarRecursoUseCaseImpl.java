package com.proyecto.biblioteca.useCase.impl;

import com.proyecto.biblioteca.dto.RecursoDTO;
import com.proyecto.biblioteca.mapper.RecursoMapper;
import com.proyecto.biblioteca.repository.BibliotecaRepository;
import com.proyecto.biblioteca.useCase.IActualizarRecursoUseCase;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
@Validated
public class ActualizarRecursoUseCaseImpl implements IActualizarRecursoUseCase {

    private final BibliotecaRepository bibliotecaRepository;
    private final RecursoMapper recursoMapper;

    public ActualizarRecursoUseCaseImpl(BibliotecaRepository bibliotecaRepository, RecursoMapper recursoMapper) {
        this.bibliotecaRepository = bibliotecaRepository;
        this.recursoMapper = recursoMapper;
    }

    @Override
    public Mono<RecursoDTO> editarRecurso(RecursoDTO recursoDTO){
        String id = Objects.requireNonNull(recursoDTO.getId(), "Por favor ingrese el id");

        return bibliotecaRepository
                .save(recursoMapper
                        .mapperToDato()
                        .apply(recursoDTO))
                .map(recurso -> recursoMapper
                        .mapDatoToDTO()
                        .apply(recurso));
    }
}
