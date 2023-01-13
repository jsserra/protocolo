/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pmm.sdgc.dao;

import com.pmm.sdgc.model.Documentos;
import com.pmm.sdgc.model.Status;
import com.pmm.sdgc.model.TipoDocumento;
import java.time.LocalDate;
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
public class DocumentosDao {

    @PersistenceContext
    EntityManager em;

    @EJB
    StatusDao daoStatus;

    @EJB
    TipoDocumentoDao daoTipo;

    public List<Documentos> getListaDocumentos() {
        Query q = em.createQuery("select d from Documentos d");
        return q.getResultList();
    }

    public Documentos getDocumentoPorNumero(String numero) {
        Query q = em.createQuery("select d from Documentos d where d.docNumero = :docNumero");
        q.setParameter("docNumero", numero);
        List<Documentos> doc = q.getResultList();
        return doc.get(0);
    }

    public Documentos getDocumentoPorId(Integer id) {
        Query q = em.createQuery("select d from Documentos d where d.id = :id");
        q.setParameter("id", id);
        List<Documentos> doc = q.getResultList();
        return doc.get(0);
    }

    public List<Documentos> getDocumentosPorAno(String ano) {
        Query q = em.createQuery("select d from Documentos d where d.docAno = :ano");
        q.setParameter("ano", ano);
        List<Documentos> doc = q.getResultList();
        return doc;
    }
    
    public List<Documentos> getDocumentosPorAssunto(String assunto) {
        Query q = em.createQuery("select d from Documentos d where d.assunto = :assunto");
        q.setParameter("assunto", assunto);
        List<Documentos> doc = q.getResultList();
        return doc;
    }

    public List<Documentos> getDocumentosFiltro(String ano, Integer idStatus, Integer idTipo) throws Exception {

        Status status = null;
        TipoDocumento tipo = null;

        if (idStatus != null) {
            status = daoStatus.getStatusPorId(idStatus);
        }

        if (idTipo != null) {
            tipo = daoTipo.getTipoPorId(idTipo);
        }

        Query q = em.createQuery("select d from Documentos d where d.status = :status and d.docTipo = :tipo");
        q.setParameter("status", status);
        q.setParameter("tipo", tipo);
        return q.getResultList();

    }

    public void postDocumentoCadastro(String numero, String ano, String assunto, String origem, Integer idStatus, Integer idTipo) throws Exception {

        Documentos documento = new Documentos();

        if (numero.isEmpty()) {
            throw new Exception("Inserir um número para o documento!");
        }

        if (ano.isEmpty()) {
            documento.setDocAno("2022");
        }

        if (idTipo == null) {
            throw new Exception("Selecionar tipo de documento");
        }

        documento.setDocNumero(numero);
        documento.setDocAno(ano);
        documento.setAssunto(assunto);
        documento.setOrigem(origem);
        
        documento.setDocTipo(daoTipo.getTipoPorId(idTipo));
        documento.setStatus(daoStatus.getStatusPorId(1));
        documento.setDataInclusao(LocalDate.now());
        em.persist(documento);

    }
    
    public void postDocumentoArquivar(Integer id) throws Exception{
        Documentos doc = getDocumentoPorId(id);
        Status status = daoStatus.getStatusPorId(2);
        
        if(doc == null){
            throw new Exception("Documento não encontrado!");
        }
        
        if(doc.getStatus() == daoStatus.getStatusPorId(2)){
            throw new Exception("Documento já está arquivado!");
        }
        
        doc.setStatus(status);
        
        em.merge(doc);    
    }

    public void postDocumentoDesarquivar(Integer id) throws Exception{
        Documentos doc = getDocumentoPorId(id);
        Status status = daoStatus.getStatusPorId(1);
        
        if(doc == null){
            throw new Exception("Documento não encontrado!");
        }
        
        if(doc.getStatus() == daoStatus.getStatusPorId(1)){
            throw new Exception("Documento já está ativo!");
        }
        
        doc.setStatus(status);
        
        em.merge(doc);    
    }

}