/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pmm.sdgc.ws.tabela;

import com.pmm.sdgc.dao.CidadesDao;
import com.pmm.sdgc.dao.EstadosDao;
import com.pmm.sdgc.model.Cidades;
import com.pmm.sdgc.model.Estados;
import com.pmm.sdgc.ws.model.ModelCidadesWs;
import com.pmm.sdgc.ws.model.ModelEstadosWs;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
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
@Path("cidades")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CidadesWs {

    @EJB
    CidadesDao daoCidades;

    @GET
    @Path("getListaCidades")
    public List<Cidades> getListaCidades() {
        try {
            return daoCidades.getCidades();
        } catch (Exception exception) {
            throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST).entity(exception.getMessage()).build());
        }
    }
    
    @GET
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
    
}
