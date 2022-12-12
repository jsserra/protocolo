/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pmm.sdgc.dao;

import com.pmm.sdgc.model.Status;
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
public class StatusDao {

    @PersistenceContext
    EntityManager em;
    
    public List<Status> getListaStatus(){
        Query q = em.createQuery("select s from Status s");
        return q.getResultList();
    }
    
    public Status getStatusPorId(Integer id){
        Status status = em.find(Status.class, id);
        return status;
    }

}
