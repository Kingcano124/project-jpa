package com.david.projectjpa.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "disquera")
public class Disquera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="idDisquera")
    private Long idDisquera;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name="fechaCreacion")
    private LocalDateTime fechaCreacion;

    @Column(name ="fechaModificacion")
    private LocalDateTime fechaModificacion;
    @Column(name ="estatus")
    private boolean status;

    public Long getIdDisquera() {
        return idDisquera;
    }

    public void setIdDisquera(Long idDisquera) {
        this.idDisquera = idDisquera;
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

    public LocalDateTime getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(LocalDateTime fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
