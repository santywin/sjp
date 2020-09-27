/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pjp.insjps.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Santiago
 */
@Entity
@Table(catalog = "bdcate", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inscripciones.findAll", query = "SELECT i FROM Inscripciones i"),
    @NamedQuery(name = "Inscripciones.findByInsCodigo", query = "SELECT i FROM Inscripciones i WHERE i.insCodigo = :insCodigo"),
    @NamedQuery(name = "Inscripciones.findByInsFecha", query = "SELECT i FROM Inscripciones i WHERE i.insFecha = :insFecha"),
    @NamedQuery(name = "Inscripciones.findByInsEstado", query = "SELECT i FROM Inscripciones i WHERE i.insEstado = :insEstado")})
public class Inscripciones implements Serializable {

    private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   @Basic(optional = false)
/*     */   @Column(name = "ins_codigo", nullable = false)
/*     */   private Integer insCodigo;
/*     */   @Column(name = "ins_fecha")
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date insFecha;
/*     */   @Size(max = 1)
/*     */   @Column(name = "ins_estado", length = 1)
/*     */   private String insEstado;
/*     */   @Column(name = "ins_valor", precision = 22)
/*     */   private Double insValor;
/*     */   @Size(max = 200)
/*     */   @Column(name = "ins_observaciones", length = 200)
/*     */   private String insObservaciones;
/*     */   @JoinColumn(name = "par_codigo", referencedColumnName = "par_codigo", nullable = false)
/*     */   @ManyToOne(optional = false)
/*     */   private Paralelos paralelos;
/*     */   @JoinColumn(name = "est_codigo", referencedColumnName = "est_codigo", nullable = false)
/*     */   @ManyToOne(optional = false)
/*     */   private Estudiantes estudiantes;

    public Inscripciones() {
    }

    public Inscripciones(Integer insCodigo) {
        this.insCodigo = insCodigo;
    }

    public Integer getInsCodigo() {
        return insCodigo;
    }

    public void setInsCodigo(Integer insCodigo) {
        this.insCodigo = insCodigo;
    }

    public Date getInsFecha() {
        return insFecha;
    }

    public void setInsFecha(Date insFecha) {
        this.insFecha = insFecha;
    }

    public String getInsEstado() {
        return insEstado;
    }

    public void setInsEstado(String insEstado) {
        this.insEstado = insEstado;
    }

    public Double getInsValor() {
        return insValor;
    }

    public void setInsValor(Double insValor) {
        this.insValor = insValor;
    }

    public String getInsObservaciones() {
        return insObservaciones;
    }

    public void setInsObservaciones(String insObservaciones) {
        this.insObservaciones = insObservaciones;
    }

    public Paralelos getParalelos() {
        return paralelos;
    }

    public void setParalelos(Paralelos paralelos) {
        this.paralelos = paralelos;
    }

    public Estudiantes getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(Estudiantes estudiantes) {
        this.estudiantes = estudiantes;
    }

 

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (insCodigo != null ? insCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inscripciones)) {
            return false;
        }
        Inscripciones other = (Inscripciones) object;
        if ((this.insCodigo == null && other.insCodigo != null) || (this.insCodigo != null && !this.insCodigo.equals(other.insCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pjp.insjps.entity.Inscripciones[ insCodigo=" + insCodigo + " ]";
    }
    
}
