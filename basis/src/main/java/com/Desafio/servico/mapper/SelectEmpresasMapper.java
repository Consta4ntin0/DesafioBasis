package com.Desafio.servico.mapper;

import com.Desafio.modelo.Empresa;
import com.Desafio.modelo.Funcionario;
import com.Desafio.servico.DTO.EmpresaSelectDTO;
import com.Desafio.servico.DTO.FuncionarioEditDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring", uses = {})
public interface SelectEmpresasMapper extends EntityMapper<EmpresaSelectDTO, Empresa> {
    @Override
    @Mapping(source = "cod", target = "cod")
    @Mapping(source = "nome", target = "nome")
    Empresa toEntity(EmpresaSelectDTO empresaDto);

    @Override
    @Mapping(source = "cod", target = "cod")
    @Mapping(source = "nome", target = "nome")
    EmpresaSelectDTO toDto(Empresa empresa);

}
