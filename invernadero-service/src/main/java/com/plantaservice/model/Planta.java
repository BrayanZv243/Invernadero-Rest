/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.plantaservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "plantas")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Planta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_planta;

    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "tipo", nullable = false)
    private String tipo;
    @Column(name = "ultimaHumedad", nullable = false)
    private Double ultimaHumedad;
    @Column(name = "ultimaVezRegada", nullable = false)
    private LocalDateTime ultimaVezRegada;
    @Column(name = "humedadOptima", nullable = false)
    private double humedadOptima;

    public Planta() {
    }

    public Planta(Integer id_planta, String nombre, LocalDateTime ultimaVezRegada, Double ultimaHumedad, double humedadOptima, String tipo) {
        this.id_planta = id_planta;
        this.nombre = nombre;
        this.ultimaVezRegada = ultimaVezRegada;
        this.ultimaHumedad = ultimaHumedad;
        this.humedadOptima = humedadOptima;
        this.tipo = tipo;
    }

    public Integer getId_planta() {
        return id_planta;
    }

    public void setId_planta(Integer id_planta) {
        this.id_planta = id_planta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDateTime getUltimaVezRegada() {
        return ultimaVezRegada;
    }

    public void setUltimaVezRegada(LocalDateTime ultimaVezRegada) {
        this.ultimaVezRegada = ultimaVezRegada;
    }

    public Double getUltimaHumedad() {
        return ultimaHumedad;
    }

    public void setUltimaHumedad(Double ultimaHumedad) {
        this.ultimaHumedad = ultimaHumedad;
    }

    public double getHumedadOptima() {
        return humedadOptima;
    }

    public void setHumedadOptima(double humedadOptima) {
        this.humedadOptima = humedadOptima;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Planta planta)) {
            return false;
        }
        return Double.compare(planta.getHumedadOptima(), getHumedadOptima()) == 0 && Objects.equals(getId_planta(), planta.getId_planta()) && Objects.equals(getNombre(), planta.getNombre()) && Objects.equals(getTipo(), planta.getTipo()) && Objects.equals(getUltimaVezRegada(), planta.getUltimaVezRegada()) && Objects.equals(getUltimaHumedad(), planta.getUltimaHumedad());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId_planta(), getNombre(), getTipo(), getUltimaVezRegada(), getUltimaHumedad(), getHumedadOptima());
    }

    @Override
    public String toString() {
        return "Planta{"
                + "id_planta=" + id_planta
                + ", nombre='" + nombre + '\''
                + ", tipo='" + tipo + '\''
                + ", ultimaVezRegada=" + ultimaVezRegada
                + ", ultimaHumedad=" + ultimaHumedad
                + ", humedadOptima=" + humedadOptima
                + '}';
    }
}
