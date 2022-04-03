package com.proyecto.biblioteca.useCase;

import com.proyecto.biblioteca.dto.RecursoDTO;
import reactor.core.publisher.Mono;

public interface IAgregarRecursoUseCase {

    Mono<RecursoDTO> addRecurso(RecursoDTO recursoDTO);
}
