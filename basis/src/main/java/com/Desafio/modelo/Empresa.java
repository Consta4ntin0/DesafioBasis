package com.Desafio.modelo;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;
import javax.persistence.*;

@Getter
@Setter
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
    @CNPJ
    private String cnpj;
    @Column
    private String endereco;

}
