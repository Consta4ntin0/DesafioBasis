package com.Desafio.modelo;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="Funcionario")

public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int cod ;
    @Column
    private String nome;
    @Column
    private Date dataNascimento;
    @Column
    private String cpf;
    @Column(name="cod_empresa")
    private int codEmpresa;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getCodEmpresa() {
        return codEmpresa;
    }
    public void setCodEmpresa(int codEmpresa) {
        this.codEmpresa = codEmpresa;
    }
}
