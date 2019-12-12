package com.Desafio.servico.mapper;

import com.Desafio.modelo.Empresa;
import com.Desafio.servico.DTO.EmpresaListDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface ListagemEmpresaMapper extends EntityMapper<EmpresaListDTO, Empresa> {

    @Override
    Empresa toEntity(EmpresaListDTO empresaListDTO);

    @Override
    EmpresaListDTO toDto(Empresa empresa);

}
