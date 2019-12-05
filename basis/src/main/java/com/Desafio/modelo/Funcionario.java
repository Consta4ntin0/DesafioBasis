package com.Desafio.modelo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
@Getter
@Setter
@Entity
@Table(name="funcionario")
@NoArgsConstructor
public class Funcionario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int cod ;
    @Column
    private String nome;
    @Column
    private Date dataNascimento;
    @CPF
    private String cpf;
    @JoinColumn(name="cod_empresa", referencedColumnName = "cod")
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Empresa empresa;

}
