package com.proyecto.biblioteca.useCase;

import reactor.core.publisher.Mono;

public interface IDevolverRecursoUseCase {
    Mono<String> devolverRecurso(String id);
}
