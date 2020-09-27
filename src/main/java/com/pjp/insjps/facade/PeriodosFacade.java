/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pjp.insjps.facade;

import com.pjp.insjps.entity.Periodos;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Santiago
 */
@Stateless
public class PeriodosFacade extends AbstractFacade<Periodos> {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PeriodosFacade() {
        super(Periodos.class);
    }
    
    /*    */   public List<Periodos> obtPeriodos() {
/* 51 */     TypedQuery typedQuery = this.em.createQuery("SELECT p FROM Periodos p ORDER BY p.perCodigo DESC", Periodos.class);
/*    */     
/*    */     try {
/* 54 */       return typedQuery.getResultList();
/*    */     
/*    */     }
/* 57 */     catch (Exception e) {
/* 58 */       return new ArrayList<>();
/*    */     } 
/*    */   }
    
}
