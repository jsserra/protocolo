/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pmm.sdgc.ws.tabela;

import com.pmm.sdgc.dao.EstadosDao;
import com.pmm.sdgc.model.Estados;
import com.pmm.sdgc.ws.model.ModelEstadosWs;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author ajuliano
 */
@Named
@Path("estados")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EstadosWs {

    @EJB
    EstadosDao daoEstados;
    
    @GET
    @Path("getListaEstados")
    public List<Estados> getListaEstados(@Context HttpHeaders headers, @Context HttpServletRequest request) {
        try {
            return daoEstados.getEstados();
        } catch (Exception exception) {
            throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST).entity(exception.getMessage()).build());
        }
    }

    @GET
    @Path("getListaEstadosWs")
    public List<Estados> getListaEstadosWs(@Context HttpHeaders headers, @Context HttpServletRequest request) {
        try {
            List<Estados> e = daoEstados.getEstados();
            //return ModelEstadosWs.toModelEstadosWs(e);
            return e;
        } catch (Exception exception) {
            throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST).entity(exception.getMessage()).build());
        }
    }
    
}
