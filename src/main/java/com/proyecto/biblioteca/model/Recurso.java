package com.proyecto.biblioteca.model;

import org.springframework.data.annotation.Id;

import java.time.LocalDate;

public class Recurso {

    @Id
    private String recursoId;
    
    private String titulo;
    private String tipo;
    private String area;
    private boolean disponible;
    private LocalDate fecha;

    public String getId() {
        return recursoId;
    }

    public void setId(String id) {
        this.recursoId = id;
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
}
