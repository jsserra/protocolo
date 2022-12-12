/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pmm.sdgc.dao;

import com.pmm.sdgc.model.Observacao;
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
public class ObservacaoDao {
    
    @PersistenceContext
    EntityManager em;
    
    public List<Observacao> getListaObservacao(){
        Query q = em.createQuery("select m from Observacao m");
        return q.getResultList();
    }
}
