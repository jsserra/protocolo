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
    
    public List<Usuarios> getListaUsuarios(){
        Query q = em.createQuery("select u from Usuarios u");
        return q.getResultList();
    }
    
    public Usuarios getUsuarioPorCPF(String cpf){
        Query q = em.createQuery("select u from Usuarios u where u.cpf = :cpf");
        q.setParameter("cpf", cpf);
        List usuarios = q.getResultList();
        if( usuarios.isEmpty()){
            return null;
        }
        return (Usuarios) usuarios.get(0);
    }

    public Usuarios getUsuarioPorChave(String chave) throws Exception{
        Query q = em.createQuery("select u from Usuarios u where u.chave = :chave and u.status = true");
        q.setParameter("chave", chave);
        List usuarios = q.getResultList();
        if( usuarios.isEmpty()){
            throw new Exception("Chave Inválida!");
        }
        return (Usuarios) usuarios.get(0);
    }
   
        public Usuarios getUsuarioPorNome(String nome) throws Exception{
        Query q = em.createQuery("select u from Usuarios u where u.nome = :nome");
        q.setParameter("nome", nome);
        List usuarios = q.getResultList();
        if( usuarios.isEmpty()){
            throw new Exception("Nome não encontrado!");
        }
        return (Usuarios) usuarios.get(0);
    }
    
    public void postUsuarioCadastro(String chave, String cpf, String nome, Integer setor, String senha, Integer acesso) throws Exception {
        
        Usuarios usuario = new Usuarios();
        
        if(chave.isEmpty() || nome.isEmpty() || cpf.isEmpty() || senha.isEmpty()){
            throw new Exception("Preencha o(s) seguinte(s) campo(s): chave, nome, cpf ou senha");
        }
               
        if ((!Usuarios.isCPF(cpf))) throw new Exception("CPF: " + cpf + " infomado é inválido!");
        
        if (getUsuarioPorCPF(cpf) != null) throw new Exception("O CFP informado já existe");
        
        Setores set = em.find(Setores.class, setor);
        for (Setores s : daoSetores.getSetores()) {
            if (set.equals(s)){
                usuario.setSetorId(s.getId());
            }else{
                throw new Exception("Setor inválido");
            }
            
        }
        usuario.setChave(chave);
        usuario.setCpf(cpf);
        usuario.setNome(nome);
        usuario.setSenha(Usuarios.encrypt(senha));
        usuario.setAcessoId(acesso);
        
        em.persist(usuario);        
    
    }
    
    public void alterarSenha(String chave, String novaSenha) throws Exception{
    
    Usuarios u = getUsuarioPorChave(chave);
    
    if(novaSenha.isEmpty()){
        novaSenha = u.getCpf();
    }
    
    u.setSenha(Usuarios.encrypt(novaSenha));
   // u.setTrocaSenha(Boolean.TRUE);
    em.merge(u);
    
    }
    
}
