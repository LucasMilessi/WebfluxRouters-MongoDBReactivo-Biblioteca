package com.proyecto.biblioteca.useCase.impl;

import com.proyecto.biblioteca.mapper.RecursoMapper;
import com.proyecto.biblioteca.repository.BibliotecaRepository;
import com.proyecto.biblioteca.useCase.IBorrarRecursoUseCase;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
@Validated
public class BorrarRecursoUseCaseImpl implements IBorrarRecursoUseCase {

    private final BibliotecaRepository bibliotecaRepository;
    private final RecursoMapper recursoMapper;

    public BorrarRecursoUseCaseImpl(BibliotecaRepository bibliotecaRepository, RecursoMapper recursoMapper) {
        this.bibliotecaRepository = bibliotecaRepository;
        this.recursoMapper = recursoMapper;
    }

    @Override
    public Mono<Void> borrarRecurso(String id){
        if(Objects.isNull(id)){
            return Mono.empty();
        }
        return bibliotecaRepository
                .deleteById(id);
    }
}
