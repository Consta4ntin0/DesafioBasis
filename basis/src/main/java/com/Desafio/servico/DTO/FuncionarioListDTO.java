package com.Desafio.servico.DTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
public class FuncionarioListDTO {

    private int cod;

    private String nome;

    private Date dataNascimento;
    @CPF
    private String cpf;

    private String nomeEmpresa;

    private String pais;

    private String uf;

    private String cidade;

    private String bairro;

    private String rua;

}
