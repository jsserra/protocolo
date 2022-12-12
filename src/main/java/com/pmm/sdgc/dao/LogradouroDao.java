package com.pmm.sdgc.dao;



import com.pmm.sdgc.model.Logradouro;
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
public class LogradouroDao {

    @PersistenceContext
    EntityManager em;

    public List<Logradouro> getLogradouro() {
        Query q = em.createQuery("select l from Logradouro l order by trim(l.nome)");
        //return q.getResultList();
        return q.setMaxResults(10).getResultList();
    }
    
    public List<Logradouro> getLogradouroPorCEP (String cep) {
        Query q = em.createQuery("select l from Logradouro l where l.cep like :cep");
        q.setParameter("cep", cep);
        return q.getResultList();
    }          
    
}
