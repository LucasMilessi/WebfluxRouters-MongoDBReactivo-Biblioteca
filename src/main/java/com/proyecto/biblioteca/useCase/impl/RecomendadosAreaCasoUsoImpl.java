package com.proyecto.biblioteca.useCase.impl;

import com.proyecto.biblioteca.dto.RecursoDTO;
import com.proyecto.biblioteca.mapper.RecursoMapper;
import com.proyecto.biblioteca.repository.BibliotecaRepository;
import com.proyecto.biblioteca.useCase.IRecomendadosTipoAreaUseCase;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;

@Service
@Validated
public class RecomendadosAreaCasoUsoImpl implements IRecomendadosTipoAreaUseCase {

    private final BibliotecaRepository bibliotecaRepository;
    private final RecursoMapper recursoMapper;


    public RecomendadosAreaCasoUsoImpl(BibliotecaRepository bibliotecaRepository, RecursoMapper recursoMapper) {
        this.bibliotecaRepository = bibliotecaRepository;
        this.recursoMapper = recursoMapper;
    }

    @Override
    public Flux<RecursoDTO> recomendarTipoArea(String area) {
        return bibliotecaRepository.findAll()
                .filter(recurso -> recurso
                        .getTipo()
                        .equals(area))
                .map(recurso -> recursoMapper
                        .mapDatoToDTO()
                        .apply(recurso));
    }
}
