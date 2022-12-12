/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pmm.sdgc.ws.tabela;

import com.pmm.sdgc.dao.BairrosDao;
import com.pmm.sdgc.model.Bairros;
import com.pmm.sdgc.ws.model.ModelBairrosWs;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.persistence.metamodel.PluralAttribute;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author ajuliano
 */
@Named
@Path("bairros")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BairrrosWs {

    @EJB
    BairrosDao daoBairros;
    

    @GET
    @Path("getListaBairros")
    public List<Bairros> getListaBairros() {
        try {
            return daoBairros.getBairros();
        } catch (Exception exception) {
            throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST).entity(exception.getMessage()).build());
        }
    }

    @GET
    @Path("getListaBairrosWs")
    public List<ModelBairrosWs> getListaBairrosWs() {
        try {
            List<Bairros> list = daoBairros.getBairros();
            List<ModelBairrosWs> mbw = list.stream().map(x -> new ModelBairrosWs(x)).collect(Collectors.toList());
            return mbw;        //instrução labda apartir java 8, 
        } catch (Exception exception) {
            throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST).entity(exception.getMessage()).build());
        }
    }
    
    @GET
    @Path("getListaBairrosPorCidadeWs/{idCidade}")
    public List<ModelBairrosWs> getListaBairrosWs(@PathParam("idCidade") Integer idCidade) {
        try {
            List<Bairros> list = daoBairros.getBairrosPorCidade(idCidade);
            List<ModelBairrosWs> mbw = list.stream().map(x -> new ModelBairrosWs(x)).collect(Collectors.toList());
            return mbw;        //instrução labda apartir java 8, 
        } catch (Exception exception) {
            throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST).entity(exception.getMessage()).build());
        }
    }

        /*@GET
    @Path("getListaCidadesPorEstado/{idEstado}")
    public List<ModelCidadesWs> getListaCidadesPorEstado(@PathParam("idEstado") Integer idEstado) {
        try {
            List<Cidades> c = daoCidades.getCidadesPorEstado(idEstado);
            return ModelCidadesWs.toModelCidadesWs(c);
        } catch (Exception exception) {
            throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST).entity(exception.getMessage()).build());
        }
    }

    @GET
    @Path("getListaCidadesWs")
    public List<ModelCidadesWs> getListaCidadesWs() {
        try {
            List<Cidades> c = daoCidades.getCidades();
            return ModelCidadesWs.toModelCidadesWs(c);
        } catch (Exception exception) {
            throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST).entity(exception.getMessage()).build());
        }
    }

    @GET
    @Path("getListaEstadosWs")
    public List<ModelEstadosWs> getListaEstadosWs() {
        try {
            List<Estados> e = daoEstados.getEstados();
            return ModelEstadosWs.toModelEstadosWs(e);
        } catch (Exception exception) {
            throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST).entity(exception.getMessage()).build());
        }
    }*/

   
    }
