/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pjp.insjps.entity;

import java.io.Serializable;
import java.util.Collection;
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
    @NamedQuery(name = "Catequistas.findAll", query = "SELECT c FROM Catequistas c"),
    @NamedQuery(name = "Catequistas.findByCatCodigo", query = "SELECT c FROM Catequistas c WHERE c.catCodigo = :catCodigo"),
    @NamedQuery(name = "Catequistas.findByCatNombre", query = "SELECT c FROM Catequistas c WHERE c.catNombre = :catNombre")})
public class Catequistas implements Serializable {

    private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   @Basic(optional = false)
/*     */   @Column(name = "cat_codigo", nullable = false)
/*     */   private Integer catCodigo;
/*     */   @Size(max = 150)
/*     */   @Column(name = "cat_nombre", length = 150)
/*     */   private String catNombre;
/*     */   @Size(max = 40)
/*     */   @Column(name = "cat_telefono", length = 40)
/*     */   private String catTelefono;
/*     */   @JoinColumn(name = "igl_codigo", referencedColumnName = "igl_codigo", nullable = false)
/*     */   @ManyToOne(optional = false)
/*     */   private Iglesias iglesias;
/*     */   @OneToMany(mappedBy = "catequistas")
/*     */   private Collection<Paralelos> paralelosCollection;

    public Catequistas() {
    }

    public Catequistas(Integer catCodigo) {
        this.catCodigo = catCodigo;
    }

    public Integer getCatCodigo() {
        return catCodigo;
    }

    public void setCatCodigo(Integer catCodigo) {
        this.catCodigo = catCodigo;
    }

    public String getCatNombre() {
        return catNombre;
    }

    public void setCatNombre(String catNombre) {
        this.catNombre = catNombre;
    }

    @XmlTransient
    public Collection<Paralelos> getParalelosCollection() {
        return paralelosCollection;
    }

    public void setParalelosCollection(Collection<Paralelos> paralelosCollection) {
        this.paralelosCollection = paralelosCollection;
    }

    public String getCatTelefono() {
        return catTelefono;
    }

    public void setCatTelefono(String catTelefono) {
        this.catTelefono = catTelefono;
    }

    public Iglesias getIglesias() {
        return iglesias;
    }

    public void setIglesias(Iglesias iglesias) {
        this.iglesias = iglesias;
    }



    @Override
    public int hashCode() {
        int hash = 0;
        hash += (catCodigo != null ? catCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Catequistas)) {
            return false;
        }
        Catequistas other = (Catequistas) object;
        if ((this.catCodigo == null && other.catCodigo != null) || (this.catCodigo != null && !this.catCodigo.equals(other.catCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pjp.insjps.entity.Catequistas[ catCodigo=" + catCodigo + " ]";
    }
    
}
