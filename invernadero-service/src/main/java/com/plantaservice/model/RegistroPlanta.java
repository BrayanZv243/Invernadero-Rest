package com.plantaservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "registro_plantas")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class RegistroPlanta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idregistro_plantas;

    @Column(name = "ultima_vez_regada", nullable = false)
    private LocalDateTime ultima_vez_regada;

    @Column(name = "ultima_humedad", nullable = false)
    private double ultima_humedad;

    @ManyToOne(optional = false)
    @JsonBackReference
    private Planta planta;

    public RegistroPlanta() {
    }

    public RegistroPlanta(Integer idregistro_plantas, LocalDateTime ultima_vez_regada, double ultima_humedad, Planta planta) {
        this.idregistro_plantas = idregistro_plantas;
        this.ultima_vez_regada = ultima_vez_regada;
        this.ultima_humedad = ultima_humedad;
        this.planta = planta;
    }

    public Integer getIdregistro_plantas() {
        return idregistro_plantas;
    }

    public void setIdregistro_plantas(Integer idregistro_plantas) {
        this.idregistro_plantas = idregistro_plantas;
    }

    public LocalDateTime getUltima_vez_regada() {
        return ultima_vez_regada;
    }

    public void setUltima_vez_regada(LocalDateTime ultima_vez_regada) {
        this.ultima_vez_regada = ultima_vez_regada;
    }

    public double getUltima_humedad() {
        return ultima_humedad;
    }

    public void setUltima_humedad(double ultima_humedad) {
        this.ultima_humedad = ultima_humedad;
    }

    public Planta getPlanta() {
        return planta;
    }

    public void setPlanta(Planta planta) {
        this.planta = planta;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.idregistro_plantas);
        hash = 97 * hash + Objects.hashCode(this.ultima_vez_regada);
        hash = 97 * hash + Objects.hashCode(this.ultima_humedad);
        hash = 97 * hash + Objects.hashCode(this.planta);
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
        final RegistroPlanta other = (RegistroPlanta) obj;
        if (!Objects.equals(this.idregistro_plantas, other.idregistro_plantas)) {
            return false;
        }
        if (!Objects.equals(this.ultima_vez_regada, other.ultima_vez_regada)) {
            return false;
        }
        if (!Objects.equals(this.ultima_humedad, other.ultima_humedad)) {
            return false;
        }
        return Objects.equals(this.planta, other.planta);
    }

    @Override
    public String toString() {
        return "RegistroPlanta{" + "idregistro_plantas=" + idregistro_plantas + ", ultima_vez_regada=" + ultima_vez_regada + ", ultima_humedad=" + ultima_humedad + ", planta=" + planta + '}';
    }

}
