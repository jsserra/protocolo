/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pmm.sdgc.ws.model;

import com.pmm.sdgc.model.Logradouro;

/**
 *
 * @author ajuliano
 */
public class ModelLogradouroWs {
    
    private String nome;
    
    public ModelLogradouroWs(){
    }

    public ModelLogradouroWs(Logradouro logradouro) {
        this.nome = logradouro.getNome();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    
}
