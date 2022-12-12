package com.pmm.sdgc.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
//import org.hibernate.annotations.NotFound;
//import org.hibernate.annotations.NotFoundAction;

/**
 *
 * @author dreges
 */
@Entity
@Table(name = "logradouro")
public class Logradouro implements Serializable {
//VAR

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "CEP")
    private String cep;

    @Column(name = "nome")
    private String nome;

    @ManyToOne
    @JoinColumn(name = "idBairro", referencedColumnName = "id")
   // @NotFound(action = NotFoundAction.IGNORE)
    private Bairros bairros;

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Bairros getBairros() {
        return bairros;
    }

    public void setBairros(Bairros bairros) {
        this.bairros = bairros;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.cep);
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
        final Logradouro other = (Logradouro) obj;
        if (!Objects.equals(this.cep, other.cep)) {
            return false;
        }
        return true;
    }

   
    
}
