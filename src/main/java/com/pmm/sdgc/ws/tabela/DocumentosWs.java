/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pmm.sdgc.ws.tabela;

import com.pmm.sdgc.dao.DocumentosDao;
import com.pmm.sdgc.dao.StatusDao;
import com.pmm.sdgc.dao.TipoDocumentoDao;
import com.pmm.sdgc.model.Documentos;
import com.pmm.sdgc.model.Status;
import com.pmm.sdgc.model.TipoDocumento;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author juliano
 */
@Named
@Path("documentos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DocumentosWs {

    @EJB
    DocumentosDao daoDocumentos;

    @EJB
    TipoDocumentoDao daoTipoDocumentos;

    @EJB
    StatusDao daoStatus;

    @GET
    @Path("getListaDocumentos")
    public List<Documentos> getListaDocumentos() {
        try {
            return daoDocumentos.getListaDocumentos();
        } catch (Exception exception) {
            throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST).entity(exception.getMessage()).build());
        }
    }

    @GET
    @Path("getDocumentoPorNumero/{num}")
    public Documentos getDocumentoPorNumero(@PathParam("num") String num) {
        try {
            return daoDocumentos.getDocumentoPorNumero(num);
        } catch (Exception exception) {
            throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST).entity(exception.getMessage()).build());
        }
    }

    @GET
    @Path("getDocumentosPorAno/{ano}")
    public List<Documentos> getDocumentosPorAno(@PathParam("ano") String ano) {
        try {
            return daoDocumentos.getDocumentosPorAno(ano);
        } catch (Exception exception) {
            throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST).entity(exception.getMessage()).build());
        }
    }

    @GET
    @Path("getDocumentosPorAssunto/{assunto}")
    public List<Documentos> getDocumentosPorAssunto(@PathParam("assunto") String assunto) {
        try {
            return daoDocumentos.getDocumentosPorAssunto(assunto);
        } catch (Exception exception) {
            throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST).entity(exception.getMessage()).build());
        }
    }

    @GET
    @Path("getDocumentosFiltro/{ano}/{status}/{tipo}")
    public List<Documentos> getDocumentosFiltro(@PathParam("ano") String ano, @PathParam("status") Integer status, @PathParam("tipo") Integer tipo) {
        try {
            return daoDocumentos.getDocumentosFiltro(ano, status, tipo);
        } catch (Exception exception) {
            throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST).entity(exception.getMessage()).build());
        }
    }
    
   @POST
   @Path("postDocumento/{numero}/{ano}/{assunto}/{origem}/{status}/{tipo}")
   public Response postDocumento(@PathParam("numero") String numero, @PathParam("ano") String ano, @PathParam("assunto") String assunto, @PathParam("origem") String origem, @PathParam("status") Integer idStatus, @PathParam("tipo") Integer idTipo){
       try{
           daoDocumentos.postDocumentoCadastro(numero, ano, assunto, origem, idStatus, idTipo);
           return Response.ok().build();
       }catch (Exception ex){
           return Response.status(Response.Status.BAD_REQUEST).entity(ex.getMessage()).build();
       }
   }

   @POST
   @Path("postDocumentoArquivar/{id}")
   public Response postDocumentoArquivar(@PathParam("id") Integer id){
       try{
           daoDocumentos.postDocumentoArquivar(id);
           return Response.ok().build();
       }catch (Exception ex){
           return Response.status(Response.Status.BAD_REQUEST).entity(ex.getMessage()).build();
       }
   }

   @POST
   @Path("postDocumentoDesarquivar/{id}")
   public Response postDocumentoDesarquivar(@PathParam("id") Integer id){
       try{
           daoDocumentos.postDocumentoDesarquivar(id);
           return Response.ok().build();
       }catch (Exception ex){
           return Response.status(Response.Status.BAD_REQUEST).entity(ex.getMessage()).build();
       }
   }

    //TipoDocumento
    @GET
    @Path("getListaTipo")
    public List<TipoDocumento> getListaTipo() {
        try {
            return daoTipoDocumentos.getListaTipo();
        } catch (Exception exception) {
            throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST).entity(exception.getMessage()).build());
        }
    }

    @GET
    @Path("getTipoPorId/{id}")
    public TipoDocumento getTipoPorId(@PathParam("id") Integer id) {
        try {
            TipoDocumento tipo = daoTipoDocumentos.getTipoPorId(id);
            return tipo;
        } catch (Exception exception) {
            throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST).entity(exception.getMessage()).build());
        }
    }

    //Status
    @GET
    @Path("getListaStatus")
    public List<Status> getListaStatus() {
        try {
            return daoStatus.getListaStatus();
        } catch (Exception exception) {
            throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST).entity(exception.getMessage()).build());
        }
    }

    @GET
    @Path("getStatusPorId/{id}")
    public Status getStatusPorId(@PathParam("id") Integer id) {
        try {
            Status status = daoStatus.getStatusPorId(id);
            return status;
        } catch (Exception exception) {
            throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST).entity(exception.getMessage()).build());
        }

    }

}
