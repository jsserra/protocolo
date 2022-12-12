/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pmm.sdgc.dao;

import com.pmm.sdgc.model.Usuarios;
import java.util.List;
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
    
    public void postUsuarioCadastro(String chave, String cpf, String nome, Integer setor, String senha, Integer acesso) throws Exception {
        
        Usuarios usuario = new Usuarios();
        
        if(chave.isEmpty() || nome.isEmpty() ){
            throw new Exception("Chave ou Nome inexistente");
        }
        
        if(cpf.isEmpty()) throw new Exception("CPF inexistente");
                
        if ((!Usuarios.isCPF(cpf))) throw new Exception("CPF: " + cpf + " infomado é inválido!");
        
        if (getUsuarioPorCPF(cpf) != null) throw new Exception("O CFP informado já existe");
        
        usuario.setChave(chave);
        usuario.setNome(nome);
        
    
    }
    
}
