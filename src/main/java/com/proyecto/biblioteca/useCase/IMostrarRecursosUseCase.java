package com.proyecto.biblioteca.useCase;

import com.proyecto.biblioteca.dto.RecursoDTO;
import reactor.core.publisher.Flux;

public interface IMostrarRecursosUseCase {

    Flux<RecursoDTO> ListarRecursos();
}
