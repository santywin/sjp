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
    @NamedQuery(name = "Iglesias.findAll", query = "SELECT i FROM Iglesias i"),
    @NamedQuery(name = "Iglesias.findByIglCodigo", query = "SELECT i FROM Iglesias i WHERE i.iglCodigo = :iglCodigo"),
    @NamedQuery(name = "Iglesias.findByIglNombre", query = "SELECT i FROM Iglesias i WHERE i.iglNombre = :iglNombre")})
public class Iglesias implements Serializable {

    private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   @Basic(optional = false)
/*     */   @Column(name = "igl_codigo", nullable = false)
/*     */   private Integer iglCodigo;
/*     */   @Size(max = 150)
/*     */   @Column(name = "igl_nombre", length = 150)
/*     */   private String iglNombre;

/*     */   @Size(max = 1000)
/*     */   @Column(name = "igl_texto", length = 1000)
/*     */   private String iglTexto;

/*     */   @OneToMany(mappedBy = "iglesias")
/*     */   private Collection<Catequistas> catequistasCollection;
/*     */   @OneToMany(mappedBy = "iglesias")
/*     */   private Collection<Estudiantes> estudiantesCollection;
/*     */   @OneToMany(mappedBy = "iglesias")
/*     */   private Collection<Paralelos> paralelosCollection;

    public Iglesias() {
    }

    public Iglesias(Integer iglCodigo) {
        this.iglCodigo = iglCodigo;
    }

    public Integer getIglCodigo() {
        return iglCodigo;
    }

    public void setIglCodigo(Integer iglCodigo) {
        this.iglCodigo = iglCodigo;
    }

    public String getIglNombre() {
        return iglNombre;
    }

    public void setIglNombre(String iglNombre) {
        this.iglNombre = iglNombre;
    }

    public String getIglTexto() {
        return iglTexto;
    }

    public void setIglTexto(String iglTexto) {
        this.iglTexto = iglTexto;
    }
    
    
    

    @XmlTransient
    public Collection<Paralelos> getParalelosCollection() {
        return paralelosCollection;
    }

    public void setParalelosCollection(Collection<Paralelos> paralelosCollection) {
        this.paralelosCollection = paralelosCollection;
    }

    @XmlTransient
    public Collection<Catequistas> getCatequistasCollection() {
        return catequistasCollection;
    }

    public void setCatequistasCollection(Collection<Catequistas> catequistasCollection) {
        this.catequistasCollection = catequistasCollection;
    }

    @XmlTransient
    public Collection<Estudiantes> getEstudiantesCollection() {
        return estudiantesCollection;
    }

    public void setEstudiantesCollection(Collection<Estudiantes> estudiantesCollection) {
        this.estudiantesCollection = estudiantesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iglCodigo != null ? iglCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Iglesias)) {
            return false;
        }
        Iglesias other = (Iglesias) object;
        if ((this.iglCodigo == null && other.iglCodigo != null) || (this.iglCodigo != null && !this.iglCodigo.equals(other.iglCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pjp.insjps.entity.Iglesias[ iglCodigo=" + iglCodigo + " ]";
    }
    
}
