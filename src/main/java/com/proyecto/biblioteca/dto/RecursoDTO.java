package com.proyecto.biblioteca.dto;

import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.Objects;

public class RecursoDTO {

    @Id
    private String id;

    private String titulo;
    private String tipo;
    private String area;
    private boolean disponible;
    private LocalDate fecha;

    public RecursoDTO() {
    }

    public RecursoDTO(String recursoid, String titulo, String tipo, String area) {
        this.id = recursoid;
        this.titulo = titulo;
        this.tipo = tipo;
        this.area = area;
        this.disponible = false;
        this.fecha = LocalDate.now();
    }

    public String getRecursoid() {
        return id;
    }

    public void setRecursoid(String recursoid) {
        this.id = recursoid;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecursoDTO that = (RecursoDTO) o;
        return disponible == that.disponible && Objects.equals(id, that.id) && Objects.equals(titulo, that.titulo) && Objects.equals(tipo, that.tipo) && Objects.equals(area, that.area) && Objects.equals(fecha, that.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titulo, tipo, area, disponible, fecha);
    }
}
