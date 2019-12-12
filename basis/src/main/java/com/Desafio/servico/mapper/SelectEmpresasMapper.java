package com.Desafio.servico.mapper;

import com.Desafio.modelo.Empresa;
import com.Desafio.servico.DTO.EmpresaSelectDTO;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring", uses = {})
public interface SelectEmpresasMapper extends EntityMapper<EmpresaSelectDTO, Empresa> {

    @Override
    Empresa toEntity(EmpresaSelectDTO empresaDto);

    @Override
    EmpresaSelectDTO toDto(Empresa empresa);

}
