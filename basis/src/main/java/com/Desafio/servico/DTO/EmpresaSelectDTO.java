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
public class EmpresaSelectDTO {
    @Id
    private int cod;
    private String nome;
}
