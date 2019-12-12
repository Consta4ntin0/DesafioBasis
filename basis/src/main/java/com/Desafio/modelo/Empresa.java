package com.Desafio.modelo;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;
import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Empresa")
public class Empresa {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cod;

    private String nome;

    @CNPJ
    private String cnpj;

    private String endereco;

    @OneToMany( mappedBy = "empresa", cascade = CascadeType.ALL)
    private List<Funcionario> funcionarios;

}
