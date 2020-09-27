/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pjp.insjps.facade;

import com.pjp.insjps.entity.Iglesias;
import com.pjp.insjps.entity.Niveles;
import com.pjp.insjps.entity.Paralelos;
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
public class ParalelosFacade extends AbstractFacade<Paralelos> {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ParalelosFacade() {
        super(Paralelos.class);
    }
    
    
    /*    */   public List<Paralelos> obtParalelos(Iglesias iglesia, Niveles nivel, Periodos periodo) {
/* 54 */     TypedQuery typedQuery = this.em.createQuery("SELECT p FROM Paralelos p WHERE p.iglesias = :iglesia and p.niveles = :nivel and p.periodos = :periodo", Paralelos.class).setParameter("iglesia", iglesia).setParameter("nivel", nivel).setParameter("periodo", periodo);
/*    */ 
/*    */ 
/*    */     
/*    */     try {
/* 59 */       return typedQuery.getResultList();
/*    */     }
/* 61 */     catch (Exception e) {
/* 62 */       return new ArrayList<>();
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public List<Paralelos> obtParalelos(Iglesias iglesia, Periodos periodo) {
/* 69 */     TypedQuery typedQuery = this.em.createQuery("SELECT p FROM Paralelos p WHERE p.iglesias = :iglesia and p.periodos = :periodo", Paralelos.class).setParameter("iglesia", iglesia).setParameter("periodo", periodo);
/*    */ 
/*    */     
/*    */     try {
/* 73 */       return typedQuery.getResultList();
/*    */     }
/* 75 */     catch (Exception e) {
/* 76 */       return new ArrayList<>();
/*    */     } 
/*    */   }
    
}
