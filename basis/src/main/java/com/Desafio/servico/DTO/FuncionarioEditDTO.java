package com.Desafio.servico.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Id;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
public class FuncionarioEditDTO {
    @Id
    private int codFunc;
    private String nomeFunc;
    private Date dataNascimentoFunc;
    @CPF
    private String cpfFunc;
    private int codEmpresa;
}
