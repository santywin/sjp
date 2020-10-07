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
    @NamedQuery(name = "Periodos.findAll", query = "SELECT p FROM Periodos p"),
    @NamedQuery(name = "Periodos.findByPerCodigo", query = "SELECT p FROM Periodos p WHERE p.perCodigo = :perCodigo"),
    @NamedQuery(name = "Periodos.findByPerNombre", query = "SELECT p FROM Periodos p WHERE p.perNombre = :perNombre")})
public class Periodos implements Serializable {

    private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   @Basic(optional = false)
/*     */   @Column(name = "per_codigo", nullable = false)
/*     */   private Integer perCodigo;
/*     */   @Size(max = 150)
/*     */   @Column(name = "per_nombre", length = 150)
/*     */   private String perNombre;
/*     */   @OneToMany(mappedBy = "periodos")
/*     */   private Collection<Paralelos> paralelosCollection;

    public Periodos() {
    }

    public Periodos(Integer perCodigo) {
        this.perCodigo = perCodigo;
    }

    public Integer getPerCodigo() {
        return perCodigo;
    }

    public void setPerCodigo(Integer perCodigo) {
        this.perCodigo = perCodigo;
    }

    public String getPerNombre() {
        return perNombre;
    }

    public void setPerNombre(String perNombre) {
        this.perNombre = perNombre;
    }

    @XmlTransient
    public Collection<Paralelos> getParalelosCollection() {
        return paralelosCollection;
    }

    public void setParalelosCollection(Collection<Paralelos> paralelosCollection) {
        this.paralelosCollection = paralelosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (perCodigo != null ? perCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Periodos)) {
            return false;
        }
        Periodos other = (Periodos) object;
        if ((this.perCodigo == null && other.perCodigo != null) || (this.perCodigo != null && !this.perCodigo.equals(other.perCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pjp.insjps.entity.Periodos[ perCodigo=" + perCodigo + " ]";
    }
    
}
