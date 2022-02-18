package com.ApEng.Ap_Engenharia.models;

import javax.persistence.*;

@Entity
@Table(name = "clientes")
public class Cliente {
    // ATRIBUTOS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private long id;

    @Column(name = "nome_cliente")
    private String nome;

    @Column(name = "cel_cliente")
    private String celular;

    @Column(name = "end_cliente")
    private String endereco;

    @Column(name = "email_cliente")
    private String email;

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
}
