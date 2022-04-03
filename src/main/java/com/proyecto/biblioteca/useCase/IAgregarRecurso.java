package com.proyecto.biblioteca.useCase;

import com.proyecto.biblioteca.dto.RecursoDTO;
import reactor.core.publisher.Mono;

public interface IAgregarRecurso {

    Mono<RecursoDTO> addRecurso(RecursoDTO recursoDTO);
}
