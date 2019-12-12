package com.Desafio.servico.DTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;

@Getter
@Setter
@NoArgsConstructor
public class EmpresaListDTO {

    private int cod;

    private String nome;

    @CNPJ
    private String cnpj;

    private String endereco;

}
