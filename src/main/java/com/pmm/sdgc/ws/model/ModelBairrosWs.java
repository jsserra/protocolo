/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pmm.sdgc.ws.model;

import com.pmm.sdgc.model.Bairros;


/**
 *
 * @author ajuliano
 */
public class ModelBairrosWs{
    
    private Integer id;
    private String nome;
    
    public ModelBairrosWs(){
    }

    public ModelBairrosWs(Bairros b) {
        id = b.getId();
        nome = b.getNome();
    }
    
  
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
   
    
}
