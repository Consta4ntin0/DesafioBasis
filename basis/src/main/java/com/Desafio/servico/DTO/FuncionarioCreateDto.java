package com.Desafio.servico.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
public class FuncionarioCreateDto {

    private int cod;

    private String nome;

    private Date dataNascimento;

    @CPF
    private String cpf;

    private int codEmpresa;

    private int codEndereco;

    private String pais;

    private String uf;

    private String cidade;

    private String bairro;

    private String rua;

    private int numero;

}
