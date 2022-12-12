package com.pmm.sdgc.dao;



import com.pmm.sdgc.model.Cidades;
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
public class CidadesDao {

    @PersistenceContext
    EntityManager em;

    public List<Cidades> getCidades() {
        Query q = em.createQuery("select c from Cidades c order by trim(c.nome)");
        //return q.getResultList();
        return q.setMaxResults(500).getResultList();
    }
    
    public List<Cidades> getCidadesPorEstado(Integer id) {
        Query q = em.createQuery("select c from Cidades c where c.estados.id like :id order by c.nome");
        q.setParameter("id", id);
        return q.getResultList();
    }  
    
}
