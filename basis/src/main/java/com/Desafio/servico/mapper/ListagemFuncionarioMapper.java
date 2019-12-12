package com.Desafio.servico.mapper;

import com.Desafio.modelo.Funcionario;
import com.Desafio.servico.DTO.FuncionarioListDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {})
public interface ListagemFuncionarioMapper extends EntityMapper<FuncionarioListDTO,Funcionario> {

    @Override
    @Mapping(source = "nomeEmpresa", target = "empresa.nome")
    @Mapping(source = "pais", target = "endereco.pais")
    @Mapping(source = "uf", target = "endereco.uf")
    @Mapping(source = "cidade", target = "endereco.cidade")
    @Mapping(source = "bairro", target = "endereco.bairro")
    @Mapping(source = "rua", target = "endereco.rua")
    Funcionario toEntity(FuncionarioListDTO funcionarioListDto);

    @Override
    @Mapping(source = "empresa.nome", target = "nomeEmpresa")
    @Mapping(source = "endereco.pais", target = "pais")
    @Mapping(source = "endereco.uf", target = "uf")
    @Mapping(source = "endereco.cidade", target = "cidade")
    @Mapping(source = "endereco.bairro", target = "bairro")
    @Mapping(source = "endereco.rua", target = "rua")
    FuncionarioListDTO toDto(Funcionario funcionario);

}
