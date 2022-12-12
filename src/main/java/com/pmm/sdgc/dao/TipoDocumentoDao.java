/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pmm.sdgc.dao;

import com.pmm.sdgc.model.TipoDocumento;
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
public class TipoDocumentoDao {
    
    @PersistenceContext
    EntityManager em;
    
    public List<TipoDocumento> getListaTipo(){
        Query q = em.createQuery("select t from TipoDocumento t");
        return q.getResultList();        
    }
    
    public TipoDocumento getTipoPorId(Integer id){
        TipoDocumento tipo = em.find(TipoDocumento.class, id);
        return tipo;
    }
}
