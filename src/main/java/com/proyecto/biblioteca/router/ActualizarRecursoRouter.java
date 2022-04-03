package com.proyecto.biblioteca.router;

import com.proyecto.biblioteca.dto.RecursoDTO;
import com.proyecto.biblioteca.useCase.impl.ActualizarRecursoUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class ActualizarRecursoRouter {

    @Bean
    public RouterFunction<ServerResponse> editarRecurso(ActualizarRecursoUseCaseImpl actualizarRecursoUseCase){

        return route(PUT("/biblioteca/editarRecurso")
                .and(accept(MediaType.APPLICATION_JSON)),
                request -> request
                        .bodyToMono(RecursoDTO.class)
                        .flatMap(recursoDTO -> actualizarRecursoUseCase
                                .editarRecurso(recursoDTO)
                                .flatMap(resultado -> ServerResponse.ok()
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .bodyValue(resultado))));
    }


}
