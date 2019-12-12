package com.Desafio.modelo;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "endereco")
public class Endereco {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cod;

    private String pais;

    private String uf;

    private String cidade;

    private String bairro;

    private String rua;

    private int numero;

    @OneToOne(mappedBy = "endereco", cascade = CascadeType.ALL)
    private Funcionario funcionario;

}
