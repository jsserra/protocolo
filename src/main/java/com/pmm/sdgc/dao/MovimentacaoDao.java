/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pmm.sdgc.dao;

import com.pmm.sdgc.model.Movimentacao;
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
public class MovimentacaoDao {
    
    @PersistenceContext
    EntityManager em;
    
    public List<Movimentacao> getListaMovimentacao(){
        Query q = em.createQuery("select m from Movimentacao m");
        return q.getResultList();
    }
}
