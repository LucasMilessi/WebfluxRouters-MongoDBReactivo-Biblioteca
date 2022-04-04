package com.proyecto.biblioteca.router;

import com.proyecto.biblioteca.useCase.impl.DevolverRecursoUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class DevolverRecursoRouter {

    @Bean
    public RouterFunction<ServerResponse> devolverRecurso(DevolverRecursoUseCaseImpl devolverRecursoUseCase){
        return route(PUT("/biblioteca/regresarRecurso/{id}")
                        .and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters
                                .fromPublisher(devolverRecursoUseCase
                                        .devolverRecurso(request
                                                .pathVariable("id")), String.class))
                        .onErrorResume(error -> ServerResponse.badRequest()
                                .build()));
    }
}
