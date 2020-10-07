/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pjp.insjps.facade;

import com.pjp.insjps.entity.Estudiantes;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Santiago
 */
@Stateless
public class EstudiantesFacade extends AbstractFacade<Estudiantes> {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstudiantesFacade() {
        super(Estudiantes.class);
    }

    public Estudiantes obtEstudiante(String cedula) {
        TypedQuery typedQuery = this.em.createQuery("SELECT e FROM Estudiantes e WHERE e.estCedula = :estCedula", Estudiantes.class).setParameter("estCedula", cedula);
        try {
            Object result = typedQuery.getSingleResult();
            return (Estudiantes) result;
        } catch (Exception e) {
            return new Estudiantes();
        }
    }

}
