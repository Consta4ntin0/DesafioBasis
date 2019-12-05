package com.Desafio.servico.mapper;

import com.Desafio.modelo.Funcionario;
import com.Desafio.servico.DTO.FuncionarioEditDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring", uses = {})
public interface EditarFuncionarioMapper extends EntityMapper<FuncionarioEditDTO,Funcionario> {
    @Override
    @Mapping(source = "codFunc", target = "cod")
    @Mapping(source = "nomeFunc", target = "nome")
    @Mapping(source = "dataNascimentoFunc", target = "dataNascimento")
    @Mapping(source = "cpfFunc", target = "cpf")
    @Mapping(source = "codEmpresa", target = "empresa.cod")
    Funcionario toEntity(FuncionarioEditDTO funcionarioDto);

    @Override
    @Mapping(source = "cod", target = "codFunc")
    @Mapping(source = "nome", target = "nomeFunc")
    @Mapping(source = "dataNascimento", target = "dataNascimentoFunc")
    @Mapping(source = "cpf", target = "cpfFunc")
    @Mapping(source = "empresa.cod", target = "codEmpresa")
    FuncionarioEditDTO toDto(Funcionario funcionario);



   /* @Override
    @Mapping(source = "cod", target = "codFunc")
    @Mapping(source = "nome", target = "nomeFunc")
    @Mapping(source = "dataNascimento", target = "dataNascimentoFunc")
    @Mapping(source = "cpf", target = "cpfFunc")
    @Mapping(source = "empresa.nome", target = "nomeEmpresa")
    List<FuncionarioDTO> toDto(List<Funcionario> funcionarioList);*/


}
