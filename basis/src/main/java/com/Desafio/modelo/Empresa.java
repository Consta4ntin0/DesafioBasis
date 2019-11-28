package com.Desafio.modelo;

import javax.persistence.*;

@Entity
@Table(name = "Empresa")
public class Empresa {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cod;
    @Column
    private String nome;
    @Column
    private String cnpj;
    @Column
    private String endereco;

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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
