package com.proyecto.biblioteca.mapper;

import com.proyecto.biblioteca.dto.RecursoDTO;
import com.proyecto.biblioteca.model.Recurso;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class RecursoMapper {

    public Function<RecursoDTO, Recurso> mapperToDato(){
        return  recursoActualizado -> {
            var recurso = new Recurso();
            recurso.setId(recursoActualizado.getId());
            recurso.setTitulo(recursoActualizado.getTitulo());
            recurso.setTipo(recursoActualizado.getTipo());
            recurso.setArea(recursoActualizado.getArea());
            recurso.setDisponible(recursoActualizado.isDisponible());
            recurso.setFecha(recursoActualizado.getFecha());
            return recurso;
        };
    }

    public Function<Recurso, RecursoDTO> mapDatoToDTO(){
        return entity -> new RecursoDTO(
                entity.getId(),
                entity.getTitulo(),
                entity.getTipo(),
                entity.getArea()
        );
    }
}
