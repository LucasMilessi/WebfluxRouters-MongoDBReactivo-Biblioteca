package com.proyecto.biblioteca.useCase;

import com.proyecto.biblioteca.dto.RecursoDTO;
import reactor.core.publisher.Mono;

public interface IActualizarRecursoUseCase {

    Mono<RecursoDTO> editarRecurso(RecursoDTO recursoDTO);
}
