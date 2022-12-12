/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pmm.sdgc.model;

import com.pmm.sdgc.converter.LocalDateAttributeConverter;
import com.pmm.sdgc.converter.LocalDateConverter1;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Converter;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
//import org.hibernate.annotations.NotFound;
//import org.hibernate.annotations.NotFoundAction;

/**
 *
 * @author juliano
 */
@Entity
@Table(name = "tb_documentos")
public class Documentos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private Integer id;

    @Column(name = "numero_documento")
    private String docNumero;

    @Column(name = "ano_documento")
    private String docAno;

    @Column(name = "caminho_doc")
    private String docCaminho;

    private String assunto;

    private String origem;

    @Column(name = "data_inclusao")
    @Convert(converter = LocalDateAttributeConverter.class)
    private LocalDate dataInclusao;

    @Column(name = "data_prazo")
    private LocalDate dataPrazo;

    @Column(name = "hr_prazo")
    private LocalDateTime prazo;

    @Column(name = "data_baixa")
    private LocalDate dataBaixa;

    @ManyToOne
    @JoinColumn(name = "tipo", referencedColumnName = "id")
    //@NotFound(action = NotFoundAction.IGNORE)
    private TipoDocumento docTipo;

    @ManyToOne
    @JoinColumn(name = "status", referencedColumnName = "id")
    //@NotFound(action = NotFoundAction.IGNORE)
    private Status status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDocNumero() {
        return docNumero;
    }

    public void setDocNumero(String docNumero) {
        this.docNumero = docNumero;
    }

    public String getDocAno() {
        return docAno;
    }

    public void setDocAno(String docAno) {
        this.docAno = docAno;
    }

    public String getDocCaminho() {
        return docCaminho;
    }

    public void setDocCaminho(String docCaminho) {
        this.docCaminho = docCaminho;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public LocalDate getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(LocalDate dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public LocalDate getDataPrazo() {
        return dataPrazo;
    }

    public void setDataPrazo(LocalDate dataPrazo) {
        this.dataPrazo = dataPrazo;
    }

    public LocalDateTime getPrazo() {
        return prazo;
    }

    public void setPrazo(LocalDateTime prazo) {
        this.prazo = prazo;
    }

    public LocalDate getDataBaixa() {
        return dataBaixa;
    }

    public void setDataBaixa(LocalDate dataBaixa) {
        this.dataBaixa = dataBaixa;
    }

    public TipoDocumento getDocTipo() {
        return docTipo;
    }

    public void setDocTipo(TipoDocumento docTipo) {
        this.docTipo = docTipo;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final Documentos other = (Documentos) obj;
        return Objects.equals(this.id, other.id);
    }

}
