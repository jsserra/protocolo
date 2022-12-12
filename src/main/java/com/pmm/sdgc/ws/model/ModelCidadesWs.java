/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pmm.sdgc.ws.model;

import com.pmm.sdgc.model.Cidades;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author setinf
 */
public class ModelCidadesWs {

    private Integer id;
    private String nome;
    private String uf;
    

    public ModelCidadesWs(Integer id, String nome, String uf) {
        this.id = id;
        this.nome = nome;
        this.uf = uf;
        
    }

    public ModelCidadesWs() {
    }

  
     public static List<ModelCidadesWs> toModelCidadesWs(List<Cidades> cidades) {
        List<ModelCidadesWs> mew = new ArrayList();
        for (Cidades c : cidades) {
            ModelCidadesWs mc = new ModelCidadesWs(
                    c.getId(),
                    c.getNome(),
                    c.getEstados().getUf()
            );
           mew.add(mc);
        }
        return mew;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
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
