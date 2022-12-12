package com.pmm.sdgc.dao;


import com.pmm.sdgc.model.Bairros;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author dreges
 */
@Stateless
public class BairrosDao {

    @PersistenceContext
    EntityManager em;

    public List<Bairros> getBairros() {
        Query q = em.createQuery("select b from Bairros b order by trim(b.nome)");
        //return q.getResultList();
        return q.setMaxResults(500).getResultList();
    }
    
    public List<Bairros> getBairrosPorCidade (Integer id) {
        Query q = em.createQuery("select b from Bairros b where b.cidades.id like :id order by b.nome");
        q.setParameter("id", id);
        return q.getResultList();
    }    
   
}
