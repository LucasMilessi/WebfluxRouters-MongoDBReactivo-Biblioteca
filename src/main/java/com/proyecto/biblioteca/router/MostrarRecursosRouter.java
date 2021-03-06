package com.proyecto.biblioteca.router;

import com.proyecto.biblioteca.dto.RecursoDTO;
import com.proyecto.biblioteca.useCase.impl.MostrarRecursosUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class MostrarRecursosRouter {

    @Bean
    public RouterFunction<ServerResponse> MostrarRecursos(MostrarRecursosUseCaseImpl listarRecursosCasoUso){

        return route(GET("/biblioteca/mostrarRecursos").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters
                                .fromPublisher(listarRecursosCasoUso
                                        .ListarRecursos(), RecursoDTO.class)));
    }

}
