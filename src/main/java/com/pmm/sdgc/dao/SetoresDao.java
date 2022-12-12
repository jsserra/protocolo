/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pmm.sdgc.dao;

import com.pmm.sdgc.model.Setores;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author juliano
 */
@Stateless
public class SetoresDao {
    
    @PersistenceContext
    EntityManager em;
    
    public List<Setores> getSetores(){
        Query q = em.createQuery("select s from Setores s");
        return q.getResultList();        
    }
}
