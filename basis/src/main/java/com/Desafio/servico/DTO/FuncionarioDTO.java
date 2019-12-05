package com.Desafio.servico.DTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Id;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
public class FuncionarioDTO {
    @Id
    private int codFunc;
    private String nomeFunc;
    private Date dataNascimentoFunc;
    private String cpfFunc;
    private String nomeEmpresa;
}
