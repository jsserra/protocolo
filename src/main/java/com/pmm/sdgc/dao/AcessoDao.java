/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pmm.sdgc.dao;

import com.pmm.sdgc.model.Acesso;
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
public class AcessoDao {
    
    @PersistenceContext
    EntityManager em;
    
    public List<Acesso> getListaAcesso(){
        
        Query q = em.createQuery("select a from Acesso a");
        return q.getResultList();
    }
    
    
}
