/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pmm.sdgc.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author juliano
 */
@Entity
@Table(name = "tb_movimentacao")
public class Movimentacao implements Serializable {

    @Id
    private Integer id;
    
    @Column(name = "usuario_id")
    private Integer usuario;
    
    @Column(name = "setor_id")
    private Integer setor;

    @Column(name = "data_entrada")
    private LocalDate dataEntrada;

    @Column(name = "data_saida")
    private LocalDate dataSaida;

    @Column(name = "data_recebido")
    private LocalDate dataRecibo;

    private String encaminhamento;

    private String destino;

    @Column(name = "log_user_id")
    private Integer logUser;

    @ManyToOne
    @JoinColumn(name = "documento_id", referencedColumnName = "id")
    private Documentos documentos;

  /*  @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuarios usuarios;

    @ManyToOne
    @JoinColumn(name = "setor_id", referencedColumnName = "id")
    private Setores setores;
    */
    
private Boolean ativo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public LocalDate getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
    }

    public LocalDate getDataRecibo() {
        return dataRecibo;
    }

    public void setDataRecibo(LocalDate dataRecibo) {
        this.dataRecibo = dataRecibo;
    }

    public String getEncaminhamento() {
        return encaminhamento;
    }

    public void setEncaminhamento(String encaminhamento) {
        this.encaminhamento = encaminhamento;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Integer getLogUser() {
        return logUser;
    }

    public void setLogUser(Integer logUser) {
        this.logUser = logUser;
    }

    public Documentos getDocumentos() {
        return documentos;
    }

    public void setDocumentos(Documentos documentos) {
        this.documentos = documentos;
    }

  /* public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    public Setores getSetores() {
        return setores;
    }

    public void setSetores(Setores setores) {
        this.setores = setores;
    }*/

    public Integer getUsuario() {
        return usuario;
    }

    public void setUsuario(Integer usuario) {
        this.usuario = usuario;
    }

    public Integer getSetor() {
        return setor;
    }

    public void setSetor(Integer setor) {
        this.setor = setor;
    }
    
    

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Movimentacao other = (Movimentacao) obj;
        return Objects.equals(this.id, other.id);
    }

}
