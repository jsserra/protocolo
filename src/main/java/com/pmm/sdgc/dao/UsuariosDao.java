/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pmm.sdgc.dao;

import com.pmm.sdgc.model.Setores;
import com.pmm.sdgc.model.Usuarios;
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
public class UsuariosDao {

    @PersistenceContext
    EntityManager em;

    @EJB
    SetoresDao daoSetores;

    public List<Usuarios> getListaUsuarios() {
        Query q = em.createQuery("select u from Usuarios u");
        return q.getResultList();
    }

    public Usuarios getUsuarioPorId(Integer idUsuario) {
        Query q = em.createQuery("select u from Usuarios u where u.id = :idUsuario");
        q.setParameter("id", idUsuario);
        List usuarios = q.getResultList();
        if (usuarios.isEmpty()) {
            return null;
        }
        return (Usuarios) usuarios.get(0);
    }

    public Usuarios getUsuarioPorCPF(String cpf) {
        Query q = em.createQuery("select u from Usuarios u where u.cpf = :cpf");
        q.setParameter("cpf", cpf);
        List usuarios = q.getResultList();
        if (usuarios.isEmpty()) {
            return null;
        }
        return (Usuarios) usuarios.get(0);
    }

    public Usuarios getUsuarioPorChave(String chave) throws Exception {
        Query q = em.createQuery("select u from Usuarios u where u.chave = :chave and u.status = true");
        q.setParameter("chave", chave);
        List usuarios = q.getResultList();
        if (usuarios.isEmpty()) {
            throw new Exception("Chave Inválida!");
        }
        return (Usuarios) usuarios.get(0);
    }

    public Usuarios getUsuarioPorNome(String nome) throws Exception {
        Query q = em.createQuery("select u from Usuarios u where u.nome = :nome");
        q.setParameter("nome", nome);
        List usuarios = q.getResultList();
        if (usuarios.isEmpty()) {
            throw new Exception("Nome não encontrado!");
        }
        return (Usuarios) usuarios.get(0);
    }

    public Usuarios getUsuarioPorMatCpfNome(String matricula, String cpf, String nome) throws Exception {

        String url = "select u from Usuarios u where";
        boolean tAnd = false;

        if (matricula.isEmpty() && cpf.isEmpty() && nome.isEmpty()) {
            System.out.println("matricula - " + matricula + " cpf - " + cpf);
            throw new Exception("Todos campos vazios!");
        }

        if (!(matricula.isEmpty())) {
            url += " u.chave like :chave ";
            tAnd = true;
        }
        
        if (!(cpf.isEmpty())) {
            if (tAnd = true) {
                url += " and";
            }
            url += " u.cpf like :cpf";
            tAnd = true;
        }
        
        if (!(nome.isEmpty())) {
            if (tAnd = true) {
                url += " and";
            }
            url += " u.nome like :nome";
        }

        Query q = em.createQuery(url);
        
        if(!(matricula.isEmpty())){
            q.setParameter("chave", matricula);
        }
        
        if(!(cpf.isEmpty())){
            q.setParameter("cpf", cpf);
        }
        
        if(!(nome.isEmpty())){
            q.setParameter("nome", "%" + nome.toUpperCase().replaceAll(" ", "%") + "%");
        }
       
        List usuarios = q.getResultList();
        if(q.getResultList().isEmpty()){
            throw new Exception("Usuário não encontrado!");
        }else{
            return (Usuarios) usuarios.get(0);
        }
        
    }

    public void postUsuarioCadastro(String chave, String cpf, String nome, Integer setor, String senha, Integer acesso) throws Exception {

        Usuarios usuario = new Usuarios();

        if (chave.isEmpty() || nome.isEmpty() || cpf.isEmpty() || senha.isEmpty()) {
            throw new Exception("Preencha o(s) seguinte(s) campo(s): chave, nome, cpf ou senha");
        }

        if ((!Usuarios.isCPF(cpf))) {
            throw new Exception("CPF: " + cpf + " infomado é inválido!");
        }

        if (getUsuarioPorCPF(cpf) != null) {
            throw new Exception("O CFP informado já existe");
        }

        Setores set = daoSetores.getSetorPorId(setor);

        usuario.setChave(chave);
        usuario.setCpf(cpf);
        usuario.setNome(nome);
        usuario.setSenha(Usuarios.encrypt(senha));
        usuario.setSetorId(set.getId());
        usuario.setAcessoId(acesso);
        usuario.setStatus(Boolean.TRUE);

        em.persist(usuario);

    }

    public Boolean getUsuarioLogin(String login, String senha) {
        String s = Usuarios.encrypt(senha);
        Query q = em.createQuery("select u from Usuarios u where u.chave = :login and u.senha = :s and u.status = true");
        q.setParameter("login", login);
        q.setParameter("senha", s);

        if (q.getResultList().isEmpty()) {
            return Boolean.FALSE;
        } else {
            return Boolean.TRUE;
        }
    }

    public void postUpdateStatusUsuario(Integer idUsuario, Boolean status) {
        Usuarios usuario = getUsuarioPorId(idUsuario);
        usuario.setStatus(status);
        em.merge(usuario);
    }

    public void alterarSenha(String chave, String novaSenha) throws Exception {

        Usuarios u = getUsuarioPorChave(chave);

        if (novaSenha.isEmpty()) {
            novaSenha = u.getCpf();
        }

        u.setSenha(Usuarios.encrypt(novaSenha));
        // u.setTrocaSenha(Boolean.TRUE);
        em.merge(u);

    }

}
