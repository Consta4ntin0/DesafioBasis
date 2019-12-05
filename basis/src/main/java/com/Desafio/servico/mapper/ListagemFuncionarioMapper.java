package com.Desafio.servico.mapper;

import com.Desafio.modelo.Funcionario;
import com.Desafio.servico.DTO.FuncionarioDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Optional;


@Mapper(componentModel = "spring", uses = {})
public interface ListagemFuncionarioMapper extends EntityMapper<FuncionarioDTO,Funcionario> {
    @Override
    @Mapping(source = "codFunc", target = "cod")
    @Mapping(source = "nomeFunc", target = "nome")
    @Mapping(source = "dataNascimentoFunc", target = "dataNascimento")
    @Mapping(source = "cpfFunc", target = "cpf")
    @Mapping(source = "nomeEmpresa", target = "empresa.nome")
    Funcionario toEntity(FuncionarioDTO funcionarioDto);

    @Override
    @Mapping(source = "cod", target = "codFunc")
    @Mapping(source = "nome", target = "nomeFunc")
    @Mapping(source = "dataNascimento", target = "dataNascimentoFunc")
    @Mapping(source = "cpf", target = "cpfFunc")
    @Mapping(source = "empresa.nome", target = "nomeEmpresa")
    FuncionarioDTO toDto(Funcionario funcionario);



   /* @Override
    @Mapping(source = "cod", target = "codFunc")
    @Mapping(source = "nome", target = "nomeFunc")
    @Mapping(source = "dataNascimento", target = "dataNascimentoFunc")
    @Mapping(source = "cpf", target = "cpfFunc")
    @Mapping(source = "empresa.nome", target = "nomeEmpresa")
    List<FuncionarioDTO> toDto(List<Funcionario> funcionarioList);*/


}
