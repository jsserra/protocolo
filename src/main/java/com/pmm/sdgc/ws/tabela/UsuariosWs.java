/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pmm.sdgc.ws.tabela;

import com.pmm.sdgc.dao.UsuariosDao;
import com.pmm.sdgc.model.Usuarios;
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
@Path("usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuariosWs {

    @EJB
    UsuariosDao daoUsuarios;

    @GET
    @Path("getListaUsuarios")
    public List<Usuarios> getListaUsuarios() {
        try {
            return daoUsuarios.getListaUsuarios();
        } catch (Exception exception) {
            throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST).entity(exception.getMessage()).build());
        }
    }

    @GET
    @Path("getUsuarioPorCPF/{cpf}")
    public Usuarios getUsuarioPorCPF(@PathParam("cpf") String cpf) {
        try {
            return daoUsuarios.getUsuarioPorCPF(cpf);
        } catch (Exception exception) {
            throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST).entity(exception.getMessage()).build());
        }
    }

    @GET
    @Path("getUsuarioPorChave/{chave}")
    public Usuarios getUsuarioPorChave(@PathParam("chave") String chave) {
        try {
            return daoUsuarios.getUsuarioPorChave(chave);
        } catch (Exception exception) {
            throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST).entity(exception.getMessage()).build());
        }
    }

    @GET
    @Path("getUsuarioLogin/{login}/{senha}")
    public Boolean getUsuarioLogin(@PathParam("login") String login, @PathParam("senha") String senha) {
        try {
            return daoUsuarios.getUsuarioLogin(login, senha);
        } catch (Exception exception) {
            throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST).entity(exception.getMessage()).build());
        }
    }

    @GET
    @Path("getUsuarioPorNome/{nome}")
    public Usuarios getUsuarioPorNome(@PathParam("nome") String nome) {
        try {
            return daoUsuarios.getUsuarioPorNome(nome);
        } catch (Exception exception) {
            throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST).entity(exception.getMessage()).build());
        }
    }

    @GET
    @Path("getUsuarioPorMatCpfNome/{matricula}/{cpf}/{nome}")
    public Usuarios getUsuarioPorMatCpfNome(@PathParam("matricula") String matricula, @PathParam("cpf") String cpf, @PathParam("nome")String nome){
        try {
            return daoUsuarios.getUsuarioPorMatCpfNome(matricula,cpf,nome);
        } catch (Exception exception) {
            throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST).entity(exception.getMessage()).build());
        }
    }

    //POST
    @POST
    @Path("postUpdateStatusUsuario/{id}/{status}")
    public Response postUpdateStatusUsuario(@PathParam("id") Integer idUsuario, @PathParam("status") Boolean status) {
        try {
            daoUsuarios.postUpdateStatusUsuario(idUsuario, status);
            return Response.ok().build();
        } catch (Exception ex) {
            return Response.status(Response.Status.BAD_REQUEST).entity(ex.getMessage()).build();
        }
    }

    @POST
    @Path("postUsuarioCadastro/{chave}/{cpf}/{nome}/{setor}/{senha}/{acesso}")
    public Response postUsuarioCadastro(@PathParam("chave") String chave, @PathParam("cpf") String cpf, @PathParam("nome") String nome, @PathParam("setor") Integer setor, @PathParam("senha") String senha, @PathParam("acesso") Integer acesso) {
        try {
            daoUsuarios.postUsuarioCadastro(chave, cpf, nome, setor, senha, acesso);
            return Response.ok().build();
        } catch (Exception ex) {
            return Response.status(Response.Status.BAD_REQUEST).entity(ex.getMessage()).build();
        }
    }
}
