package com.david.projectjpa.entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "SubGenero")
public class SubGenero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSubGenero;

    @Column(name = "descripcion")
    private String descripcion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idGenero")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Genero genero;

    @Column(name = "fechaCreacion")
    private LocalDateTime fechaCreacion;


    @Column(name ="fechaModificacion")
    private LocalDateTime fechaModificacion;

    @Column(name = "estatus")
    private boolean status;

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }


    public LocalDateTime getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(LocalDateTime fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
