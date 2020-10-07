/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pjp.insjps.facade;

import com.pjp.insjps.entity.Catequistas;
import com.pjp.insjps.entity.Iglesias;
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
public class CatequistasFacade extends AbstractFacade<Catequistas> {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CatequistasFacade() {
        super(Catequistas.class);
    }
    
     public List<Catequistas> obtCatequistas(Iglesias iglesia) {
/* 39 */     TypedQuery typedQuery = this.em.createQuery("SELECT c FROM Catequistas c WHERE c.iglesias = :iglesia", Catequistas.class).setParameter("iglesia", iglesia);
/*    */     
/*    */     try {
/* 42 */       return typedQuery.getResultList();
/*    */     
/*    */     }
/* 45 */     catch (Exception e) {
/* 46 */       return new ArrayList<>();
/*    */     } 
/*    */   }
    
    
}
