package com.proyecto.biblioteca.useCase;

import reactor.core.publisher.Mono;

public interface IPrestarRecursoCasoUso {
    Mono<String> prestarRecurso(String id);
}
