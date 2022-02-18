package com.ApEng.Ap_Engenharia.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "parceiros")
public class Parceiro implements Serializable {

    private static final long serialVersionUID = 1L;

    // ATRIBUTOS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_parceiro")
    private long id;

    @Column(name = "nome_parceiro")
    private String nome;

    @Column(name = "cel_parceiro")
    private String celular;

    @Column(name = "end_parceiro")
    private String endereco;

    @Column(name = "email_parceiro")
    private String email;

    @Column(name = "cnpj_parceiro")
    private String cnpj;

    @OneToMany(mappedBy = "parceiros", cascade = CascadeType.REMOVE)
    private Projeto projeto;


    // GETTER & SETTER
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
