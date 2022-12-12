package com.pmm.sdgc.dao;


import com.pmm.sdgc.model.Estados;
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
public class EstadosDao {

    @PersistenceContext
    EntityManager em;

    public List<Estados> getEstados() {
        //Query q = em.createQuery("select e from Estados e order by trim(e.nome)");
        Query q = em.createQuery("select e from Estados e");
        //return q.setMaxResults(10).getResultList();
        return q.getResultList();
    }
      
}
