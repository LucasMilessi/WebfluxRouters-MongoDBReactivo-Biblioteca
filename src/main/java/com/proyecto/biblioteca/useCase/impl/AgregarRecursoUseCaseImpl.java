package com.proyecto.biblioteca.useCase.impl;

import com.proyecto.biblioteca.dto.RecursoDTO;
import com.proyecto.biblioteca.mapper.RecursoMapper;
import com.proyecto.biblioteca.repository.BibliotecaRepository;
import com.proyecto.biblioteca.useCase.IAgregarRecurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class AgregarRecursoUseCaseImpl implements IAgregarRecurso {

    private final BibliotecaRepository bibliotecaRepository;
    private final RecursoMapper mapper;

    @Autowired
    public AgregarRecursoUseCaseImpl(BibliotecaRepository bibliotecaRepository, RecursoMapper mapper) {
        this.bibliotecaRepository = bibliotecaRepository;
        this.mapper = mapper;
    }

    @Override
    public Mono<RecursoDTO> addRecurso(RecursoDTO recursoDTO) {
        return bibliotecaRepository
                .save(mapper
                        .mapperToDato()
                        .apply(recursoDTO))
                .map(recurso -> mapper
                        .mapDatoToDTO()
                        .apply(recurso));
    }
}
