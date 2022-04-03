package com.proyecto.biblioteca.useCase;

import reactor.core.publisher.Mono;

public interface IBorrarRecursoUseCase {

    Mono<Void> borrarRecurso(String id);
}
