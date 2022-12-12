/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pmm.sdgc.ws.model;

import com.pmm.sdgc.model.Estados;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author setinf
 */
public class ModelEstadosWs {

    private Integer id;
    private String nome;
    private String uf;
    

    public ModelEstadosWs(Integer id, String nome, String uf) {
        this.id = id;
        this.nome = nome;
        this.uf = uf;
    }

    public ModelEstadosWs() {
    }

  
     public static List<ModelEstadosWs> toModelEstadosWs(List<Estados> estados) {
        List<ModelEstadosWs> mew = new ArrayList();
        for (Estados e : estados) {
            ModelEstadosWs lw = new ModelEstadosWs(
                    e.getId(),
                    e.getNome(),
                    e.getUf()
            );
           mew.add(lw);
        }
        return mew;
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

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
   
}
