/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pjp.insjps.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
    @NamedQuery(name = "Estudiantes.findAll", query = "SELECT e FROM Estudiantes e"),
    @NamedQuery(name = "Estudiantes.findByEstCodigo", query = "SELECT e FROM Estudiantes e WHERE e.estCodigo = :estCodigo"),
    @NamedQuery(name = "Estudiantes.findByEstCedula", query = "SELECT e FROM Estudiantes e WHERE e.estCedula = :estCedula"),
    @NamedQuery(name = "Estudiantes.findByEstNombre", query = "SELECT e FROM Estudiantes e WHERE e.estNombre = :estNombre"),
    @NamedQuery(name = "Estudiantes.findByEstNomPadre", query = "SELECT e FROM Estudiantes e WHERE e.estNomPadre = :estNomPadre"),
    @NamedQuery(name = "Estudiantes.findByEstNomMadre", query = "SELECT e FROM Estudiantes e WHERE e.estNomMadre = :estNomMadre"),
    @NamedQuery(name = "Estudiantes.findByEstTelefono", query = "SELECT e FROM Estudiantes e WHERE e.estTelefono = :estTelefono"),
    @NamedQuery(name = "Estudiantes.findByEstCelular", query = "SELECT e FROM Estudiantes e WHERE e.estCelular = :estCelular"),
    @NamedQuery(name = "Estudiantes.findByEstFecNacimiento", query = "SELECT e FROM Estudiantes e WHERE e.estFecNacimiento = :estFecNacimiento"),
    @NamedQuery(name = "Estudiantes.findByEstFecBautismo", query = "SELECT e FROM Estudiantes e WHERE e.estFecBautismo = :estFecBautismo"),
    @NamedQuery(name = "Estudiantes.findByEstRepresentante", query = "SELECT e FROM Estudiantes e WHERE e.estRepresentante = :estRepresentante"),
    @NamedQuery(name = "Estudiantes.findByEstParRepresentante", query = "SELECT e FROM Estudiantes e WHERE e.estParRepresentante = :estParRepresentante"),
    @NamedQuery(name = "Estudiantes.findByEstPadCas", query = "SELECT e FROM Estudiantes e WHERE e.estPadCas = :estPadCas")})
public class Estudiantes implements Serializable {

    private static final long serialVersionUID = 1L;
/*     */   @Id
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   @Basic(optional = false)
/*     */   @Column(name = "est_codigo", nullable = false)
/*     */   private Integer estCodigo;
/*     */   @Size(max = 10)
/*     */   @Column(name = "est_cedula", length = 10)
/*     */   private String estCedula;
/*     */   @Size(max = 1)
/*     */   @Column(name = "est_pad_cas", length = 1)
/*     */   private String estPadCas;
/*     */   @Size(max = 150)
/*     */   @Column(name = "est_nombre", length = 150)
/*     */   private String estNombre;
/*     */   @Size(max = 150)
/*     */   @Column(name = "est_nom_padre", length = 150)
/*     */   private String estNomPadre;
/*     */   @Size(max = 150)
/*     */   @Column(name = "est_nom_madre", length = 150)
/*     */   private String estNomMadre;
/*     */   @Size(max = 200)
/*     */   @Column(name = "est_direccion", length = 200)
/*     */   private String estDireccion;
/*     */   @Size(max = 15)
/*     */   @Column(name = "est_telefono", length = 15)
/*     */   private String estTelefono;
/*     */   @Size(max = 15)
/*     */   @Column(name = "est_celular", length = 15)
/*     */   private String estCelular;
/*     */   @Column(name = "est_fec_nacimiento")
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date estFecNacimiento;
/*     */   @Column(name = "est_fec_bautismo")
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date estFecBautismo;
/*     */   @Size(max = 150)
/*     */   @Column(name = "est_representante", length = 150)
/*     */   private String estRepresentante;
/*     */   @Size(max = 1)
/*     */   @Column(name = "est_par_representante", length = 1)
/*     */   private String estParRepresentante;
/*     */   @JoinColumn(name = "igl_codigo", referencedColumnName = "igl_codigo", nullable = false)
/*     */   @ManyToOne(optional = false)
/*     */   private Iglesias iglesias;
/*     */   @OneToMany(mappedBy = "estudiantes")
/*     */   private Collection<Inscripciones> inscripcionesCollection;

    public Estudiantes() {
    }

    public Estudiantes(Integer estCodigo) {
        this.estCodigo = estCodigo;
    }

    public Integer getEstCodigo() {
        return estCodigo;
    }

    public void setEstCodigo(Integer estCodigo) {
        this.estCodigo = estCodigo;
    }

    public String getEstCedula() {
        return estCedula;
    }

    public void setEstCedula(String estCedula) {
        this.estCedula = estCedula;
    }

    public String getEstNombre() {
        return estNombre;
    }

    public void setEstNombre(String estNombre) {
        this.estNombre = estNombre;
    }

    public String getEstNomPadre() {
        return estNomPadre;
    }

    public void setEstNomPadre(String estNomPadre) {
        this.estNomPadre = estNomPadre;
    }

    public String getEstNomMadre() {
        return estNomMadre;
    }

    public void setEstNomMadre(String estNomMadre) {
        this.estNomMadre = estNomMadre;
    }

    public String getEstTelefono() {
        return estTelefono;
    }

    public void setEstTelefono(String estTelefono) {
        this.estTelefono = estTelefono;
    }

    public String getEstCelular() {
        return estCelular;
    }

    public void setEstCelular(String estCelular) {
        this.estCelular = estCelular;
    }

    public Date getEstFecNacimiento() {
        return estFecNacimiento;
    }

    public void setEstFecNacimiento(Date estFecNacimiento) {
        this.estFecNacimiento = estFecNacimiento;
    }

    public Date getEstFecBautismo() {
        return estFecBautismo;
    }

    public void setEstFecBautismo(Date estFecBautismo) {
        this.estFecBautismo = estFecBautismo;
    }

    public String getEstRepresentante() {
        return estRepresentante;
    }

    public void setEstRepresentante(String estRepresentante) {
        this.estRepresentante = estRepresentante;
    }

    public String getEstParRepresentante() {
        return estParRepresentante;
    }

    public void setEstParRepresentante(String estParRepresentante) {
        this.estParRepresentante = estParRepresentante;
    }

    public String getEstPadCas() {
        return estPadCas;
    }

    public void setEstPadCas(String estPadCas) {
        this.estPadCas = estPadCas;
    }

    @XmlTransient
    public Collection<Inscripciones> getInscripcionesCollection() {
        return inscripcionesCollection;
    }

    public void setInscripcionesCollection(Collection<Inscripciones> inscripcionesCollection) {
        this.inscripcionesCollection = inscripcionesCollection;
    }

    public String getEstDireccion() {
        return estDireccion;
    }

    public void setEstDireccion(String estDireccion) {
        this.estDireccion = estDireccion;
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
        hash += (estCodigo != null ? estCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estudiantes)) {
            return false;
        }
        Estudiantes other = (Estudiantes) object;
        if ((this.estCodigo == null && other.estCodigo != null) || (this.estCodigo != null && !this.estCodigo.equals(other.estCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pjp.insjps.entity.Estudiantes[ estCodigo=" + estCodigo + " ]";
    }
    
}
