/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pmm.sdgc.ws.tabela;

import com.pmm.sdgc.dao.BairrosDao;
import com.pmm.sdgc.dao.LogradouroDao;
import com.pmm.sdgc.model.Bairros;
import com.pmm.sdgc.model.Logradouro;
import com.pmm.sdgc.ws.model.ModelBairrosWs;
import com.pmm.sdgc.ws.model.ModelLogradouroCEPWs;
import com.pmm.sdgc.ws.model.ModelLogradouroWs;
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
@Path("logradouro")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LogradouroWs {

    @EJB
    LogradouroDao daoLogradouro;
    

    @GET
    @Path("getListaLogradouro")
    public List<Logradouro> getListaLogradouro() {
        try {
            return daoLogradouro.getLogradouro();
        } catch (Exception exception) {
            throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST).entity(exception.getMessage()).build());
        }
    }

    @GET
    @Path("getListaLogradouroWs")
    public List<ModelLogradouroWs> getListaLogradouroWs() {
        try {
            List<Logradouro> list = daoLogradouro.getLogradouro();
            List<ModelLogradouroWs> mlw = list.stream().map(x -> new ModelLogradouroWs(x)).collect(Collectors.toList());
            return mlw;        //instrução lambda apartir java 8, 
        } catch (Exception exception) {
            throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST).entity(exception.getMessage()).build());
        }
    }
    
    @GET
    @Path("getListaLogradouroPorCEP/{cep}")
    public List<ModelLogradouroCEPWs> getListaLogradouroPorCEP(@PathParam("cep") String cep) {
        try {
            List<Logradouro> list = daoLogradouro.getLogradouroPorCEP(cep);
            List<ModelLogradouroCEPWs> mlw = list.stream().map(x -> new ModelLogradouroCEPWs(x)).collect(Collectors.toList());
            return mlw;        //instrução lambda apartir java 8, 
        } catch (Exception exception) {
            throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST).entity(exception.getMessage()).build());
        }
    }

 
    }
