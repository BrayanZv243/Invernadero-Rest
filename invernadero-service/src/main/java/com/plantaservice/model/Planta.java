/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.plantaservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
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

    @Column(name = "humedad_optima", nullable = false)
    private double humedad_optima;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "planta")
    @JsonManagedReference
    private List<RegistroPlanta> registroPlanta;

    public Planta() {
        super();
    }

    public Planta(Integer id_planta, String nombre, String tipo, double humedad_optima, List<RegistroPlanta> registroPlanta) {
        this.id_planta = id_planta;
        this.nombre = nombre;
        this.tipo = tipo;
        this.humedad_optima = humedad_optima;
        this.registroPlanta = registroPlanta;
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

    public double getHumedad_optima() {
        return humedad_optima;
    }

    public void setHumedad_optima(double humedad_optima) {
        this.humedad_optima = humedad_optima;
    }

    public List<RegistroPlanta> getRegistroPlanta() {
        return registroPlanta;
    }

    public void setRegistroPlanta(List<RegistroPlanta> registroPlanta) {
        this.registroPlanta = registroPlanta;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id_planta);
        hash = 97 * hash + Objects.hashCode(this.nombre);
        hash = 97 * hash + Objects.hashCode(this.tipo);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.humedad_optima) ^ (Double.doubleToLongBits(this.humedad_optima) >>> 32));
        hash = 97 * hash + Objects.hashCode(this.registroPlanta);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Planta other = (Planta) obj;
        if (Double.doubleToLongBits(this.humedad_optima) != Double.doubleToLongBits(other.humedad_optima)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        if (!Objects.equals(this.id_planta, other.id_planta)) {
            return false;
        }
        return Objects.equals(this.registroPlanta, other.registroPlanta);
    }

    @Override
    public String toString() {
        return "Planta{" + "id_planta=" + id_planta + ", nombre=" + nombre + ", tipo=" + tipo + ", humedad_optima=" + humedad_optima + ", registroPlanta=" + registroPlanta + '}';
    }

}
