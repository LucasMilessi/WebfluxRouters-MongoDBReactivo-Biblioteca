package com.proyecto.biblioteca.useCase.impl;

import com.proyecto.biblioteca.dto.RecursoDTO;
import com.proyecto.biblioteca.mapper.RecursoMapper;
import com.proyecto.biblioteca.repository.BibliotecaRepository;
import com.proyecto.biblioteca.useCase.IMostrarRecursosUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;

@Service
@Validated
public class MostrarRecursosUseCaseImpl implements IMostrarRecursosUseCase {

    private final BibliotecaRepository bibliotecaRepository;
    private final RecursoMapper mapper;

    @Autowired
    public MostrarRecursosUseCaseImpl(BibliotecaRepository bibliotecaRepository, RecursoMapper mapper) {
        this.bibliotecaRepository = bibliotecaRepository;
        this.mapper = mapper;
    }


    @Override
    public Flux<RecursoDTO> ListarRecursos() {
        return bibliotecaRepository
                .findAll()
                .map(mapper.mapDatoToDTO());
    }
}
