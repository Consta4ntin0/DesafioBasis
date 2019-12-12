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
@Table(name = "funcionario")
@NoArgsConstructor
public class Funcionario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cod ;

    private String nome;

    private Date dataNascimento;

    @CPF
    private String cpf;

    @JoinColumn( name="cod_empresa", referencedColumnName = "cod")
    @ManyToOne
    private Empresa empresa;

    @JoinColumn( name = "cod_endereco", referencedColumnName = "cod")
    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;

}
