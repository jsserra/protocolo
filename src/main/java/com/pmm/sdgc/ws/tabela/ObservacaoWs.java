/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pmm.sdgc.ws.tabela;

import com.pmm.sdgc.dao.ObservacaoDao;
import com.pmm.sdgc.dao.UsuariosDao;
import com.pmm.sdgc.model.Observacao;
import com.pmm.sdgc.model.Usuarios;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author juliano
 */
@Named
@Path("observacao")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ObservacaoWs {

    @EJB
    ObservacaoDao daoObs;

    @GET
    @Path("getListaobservacao")
    public List<Observacao> getListaObservacao() {
        try {
            return daoObs.getListaObservacao();
        } catch (Exception exception) {
            throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST).entity(exception.getMessage()).build());
        }
    }
}
