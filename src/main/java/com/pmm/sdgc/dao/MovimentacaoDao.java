/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pmm.sdgc.dao;

import com.pmm.sdgc.model.Movimentacao;
import com.pmm.sdgc.model.TipoDocumento;
import java.util.List;
import javax.ejb.EJB;
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
    
    @EJB
    TipoDocumentoDao daoTipo;
    
    @EJB
    DocumentosDao daoDocumento;
    
    @EJB
    SetoresDao daoSetores;
    
    public List<Movimentacao> getListaMovimentacao() {
        Query q = em.createQuery("select m from Movimentacao m");
        return q.getResultList();
    }
    
    public Movimentacao getMovimentacaoPorId(Integer id) throws Exception {
        Query q = em.createQuery("select m from Movimentacao m where m.id = :id");
        q.setParameter("id", id);
        List<Movimentacao> movimentacoes = q.getResultList();
        if (movimentacoes.isEmpty()) {
            throw new Exception("Movimentação inexistente!");
        }
        return movimentacoes.get(0);
    }
    
    public void postMovimentacao(Integer id, Integer idDocumento, Integer idUsuario, Integer idSetor, Integer idTipo, String encaminhamento) throws Exception {
        
        Movimentacao movimentacao = getMovimentacaoPorId(id);
        
        TipoDocumento tipo = daoTipo.getTipoPorId(idTipo);
        
        if (idDocumento == null || idUsuario == null || idSetor == null || encaminhamento.isEmpty()) {
            throw new Exception("Favor preencher os campos: documento, usuario, setor, assunto!");
        }
        
        if (!(movimentacao == null)) {
            
        }
        
        if (movimentacao == null) {
            movimentacao = new Movimentacao();
            
            movimentacao.setDocumentos(daoDocumento.getDocumentoPorId(idDocumento));
            movimentacao.setSetor(idSetor);
            movimentacao.setUsuario(idUsuario);
            
        }
        
    }
}
