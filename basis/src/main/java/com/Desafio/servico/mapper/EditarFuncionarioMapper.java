package com.Desafio.servico.mapper;

import com.Desafio.modelo.Funcionario;
import com.Desafio.servico.DTO.FuncionarioCreateDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring", uses = {})
public interface EditarFuncionarioMapper extends EntityMapper<FuncionarioCreateDto,Funcionario> {

    @Override
    @Mapping(source = "codEmpresa", target = "empresa.cod")
    @Mapping(source = "codEndereco", target = "endereco.cod")
    @Mapping(source = "pais", target = "endereco.pais")
    @Mapping(source = "uf", target = "endereco.uf")
    @Mapping(source = "cidade", target = "endereco.cidade")
    @Mapping(source = "bairro", target = "endereco.bairro")
    @Mapping(source = "rua", target = "endereco.rua")
    @Mapping(source = "numero", target = "endereco.numero")
    Funcionario toEntity(FuncionarioCreateDto funcionarioDto);

    @Override
    @Mapping(source = "empresa.cod", target = "codEmpresa")
    @Mapping(source = "endereco.cod", target = "codEndereco")
    @Mapping(source = "endereco.pais", target = "pais")
    @Mapping(source = "endereco.uf", target = "uf")
    @Mapping(source = "endereco.cidade", target = "cidade")
    @Mapping(source = "endereco.bairro", target = "bairro")
    @Mapping(source = "endereco.rua", target = "rua")
    @Mapping(source = "endereco.numero", target = "numero")
    FuncionarioCreateDto toDto(Funcionario funcionario);

}
