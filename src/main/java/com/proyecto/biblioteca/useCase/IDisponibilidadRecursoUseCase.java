package com.proyecto.biblioteca.useCase;

import reactor.core.publisher.Mono;

public interface IDisponibilidadRecursoUseCase {

    Mono<String> consultarDisponibilidad(String id);
}
