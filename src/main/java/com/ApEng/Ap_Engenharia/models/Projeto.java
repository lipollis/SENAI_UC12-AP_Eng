package com.ApEng.Ap_Engenharia.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "projetos")
public class Projeto implements Serializable {

    private static final long serialVersionUID = 1L;

    // ATRIBUTOS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_projeto")
    private long id;

    @Column(name = "nome_projeto")
    private String nome;

    @Column(name = "data_inicio")
    private Date dataInicio;

    @Column(name = "data_final")
    private Date dataFinal;

    @Column(name = "valor_projeto")
    private double valorProjeto;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE) // RELACIONAMENTO 1:1
    private Cliente cliente;

    @OneToMany(mappedBy = "projetos", cascade = CascadeType.REMOVE)
    private Terceirizado terceirizado;

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

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public double getValorProjeto() {
        return valorProjeto;
    }

    public void setValorProjeto(double valorProjeto) {
        this.valorProjeto = valorProjeto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Terceirizado getTerceirizado() {
        return terceirizado;
    }

    public void setTerceirizado(Terceirizado terceirizado) {
        this.terceirizado = terceirizado;
    }
}
