/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pjp.insjps.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Santiago
 */
@Entity
@Table(catalog = "bdcate", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paralelos.findAll", query = "SELECT p FROM Paralelos p"),
    @NamedQuery(name = "Paralelos.findByParCodigo", query = "SELECT p FROM Paralelos p WHERE p.parCodigo = :parCodigo"),
    @NamedQuery(name = "Paralelos.findByParNombre", query = "SELECT p FROM Paralelos p WHERE p.parNombre = :parNombre"),
    @NamedQuery(name = "Paralelos.findByParAtributo", query = "SELECT p FROM Paralelos p WHERE p.parAtributo = :parAtributo")})
public class Paralelos implements Serializable {

    private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   @Basic(optional = false)
/*     */   @Column(name = "par_codigo", nullable = false)
/*     */   private Integer parCodigo;
/*     */   @Size(max = 150)
/*     */   @Column(name = "par_nombre", length = 150)
/*     */   private String parNombre;
/*     */   @Size(max = 1)
/*     */   @Column(name = "par_atributo", length = 1)
/*     */   private String parAtributo;
/*     */   @OneToMany(mappedBy = "paralelos")
/*     */   private Collection<Inscripciones> inscripcionesCollection;
/*     */   @JoinColumn(name = "per_codigo", referencedColumnName = "per_codigo", nullable = false)
/*     */   @ManyToOne(optional = false)
/*     */   private Periodos periodos;
/*     */   @JoinColumn(name = "igl_codigo", referencedColumnName = "igl_codigo", nullable = false)
/*     */   @ManyToOne(optional = false)
/*     */   private Iglesias iglesias;
/*     */   @JoinColumn(name = "niv_codigo", referencedColumnName = "niv_codigo", nullable = false)
/*     */   @ManyToOne(optional = false)
/*     */   private Niveles niveles;
/*     */   @JoinColumn(name = "cat_codigo", referencedColumnName = "cat_codigo")
/*     */   @ManyToOne
/*     */   private Catequistas catequistas;

    public Paralelos() {
    }

    public Paralelos(Integer parCodigo) {
        this.parCodigo = parCodigo;
    }

    public Integer getParCodigo() {
        return parCodigo;
    }

    public void setParCodigo(Integer parCodigo) {
        this.parCodigo = parCodigo;
    }

    public String getParNombre() {
        return parNombre;
    }

    public void setParNombre(String parNombre) {
        this.parNombre = parNombre;
    }

    public String getParAtributo() {
        return parAtributo;
    }

    public void setParAtributo(String parAtributo) {
        this.parAtributo = parAtributo;
    }

    @XmlTransient
    public Collection<Inscripciones> getInscripcionesCollection() {
        return inscripcionesCollection;
    }

    public void setInscripcionesCollection(Collection<Inscripciones> inscripcionesCollection) {
        this.inscripcionesCollection = inscripcionesCollection;
    }

    public Periodos getPeriodos() {
        return periodos;
    }

    public void setPeriodos(Periodos periodos) {
        this.periodos = periodos;
    }

    public Iglesias getIglesias() {
        return iglesias;
    }

    public void setIglesias(Iglesias iglesias) {
        this.iglesias = iglesias;
    }

    public Niveles getNiveles() {
        return niveles;
    }

    public void setNiveles(Niveles niveles) {
        this.niveles = niveles;
    }

    public Catequistas getCatequistas() {
        return catequistas;
    }

    public void setCatequistas(Catequistas catequistas) {
        this.catequistas = catequistas;
    }



    @Override
    public int hashCode() {
        int hash = 0;
        hash += (parCodigo != null ? parCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paralelos)) {
            return false;
        }
        Paralelos other = (Paralelos) object;
        if ((this.parCodigo == null && other.parCodigo != null) || (this.parCodigo != null && !this.parCodigo.equals(other.parCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pjp.insjps.entity.Paralelos[ parCodigo=" + parCodigo + " ]";
    }
    
}
