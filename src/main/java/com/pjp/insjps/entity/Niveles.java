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
    @NamedQuery(name = "Niveles.findAll", query = "SELECT n FROM Niveles n"),
    @NamedQuery(name = "Niveles.findByNivCodigo", query = "SELECT n FROM Niveles n WHERE n.nivCodigo = :nivCodigo"),
    @NamedQuery(name = "Niveles.findByNivNombre", query = "SELECT n FROM Niveles n WHERE n.nivNombre = :nivNombre")})
public class Niveles implements Serializable {

    private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   @Basic(optional = false)
/*     */   @Column(name = "niv_codigo", nullable = false)
/*     */   private Integer nivCodigo;
/*     */   @Size(max = 150)
/*     */   @Column(name = "niv_nombre", length = 150)
/*     */   private String nivNombre;
/*     */   @OneToMany(mappedBy = "niveles")
/*     */   private Collection<Paralelos> paralelosCollection;

    public Niveles() {
    }

    public Niveles(Integer nivCodigo) {
        this.nivCodigo = nivCodigo;
    }

    public Integer getNivCodigo() {
        return nivCodigo;
    }

    public void setNivCodigo(Integer nivCodigo) {
        this.nivCodigo = nivCodigo;
    }

    public String getNivNombre() {
        return nivNombre;
    }

    public void setNivNombre(String nivNombre) {
        this.nivNombre = nivNombre;
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
        hash += (nivCodigo != null ? nivCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Niveles)) {
            return false;
        }
        Niveles other = (Niveles) object;
        if ((this.nivCodigo == null && other.nivCodigo != null) || (this.nivCodigo != null && !this.nivCodigo.equals(other.nivCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pjp.insjps.entity.Niveles[ nivCodigo=" + nivCodigo + " ]";
    }
    
}
