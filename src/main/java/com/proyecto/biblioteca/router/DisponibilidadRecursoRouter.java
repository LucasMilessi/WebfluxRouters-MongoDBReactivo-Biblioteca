package com.proyecto.biblioteca.router;

import com.proyecto.biblioteca.useCase.impl.DisponibilidadRecursoUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class DisponibilidadRecursoRouter {

    @Bean
    public RouterFunction<ServerResponse> disponibilidadRecurso(DisponibilidadRecursoUseCaseImpl disponibilidadRecursoCasoUso){
        return route(GET("/biblioteca/recursoDisponible/{id}"),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters
                                .fromPublisher(disponibilidadRecursoCasoUso
                                        .consultarDisponibilidad(request
                                                .pathVariable("id")), String.class))
                        .onErrorResume(error -> ServerResponse
                                .badRequest()
                                .build()));
    }
}
