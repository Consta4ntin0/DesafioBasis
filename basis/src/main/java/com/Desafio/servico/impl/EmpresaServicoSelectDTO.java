package com.Desafio.servico.impl;

import com.Desafio.repositorio.EmpresaRepositorio;
import com.Desafio.servico.DTO.EmpresaSelectDTO;
import com.Desafio.servico.mapper.SelectEmpresasMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaServicoSelectDTO {

    @Autowired
    EmpresaRepositorio empresaRepositorio;

    @Autowired
    SelectEmpresasMapper selectEmpresasMapper;

    public List<EmpresaSelectDTO> listarEmpresas(){
        return selectEmpresasMapper.toDto(empresaRepositorio.findAll());
    }

}
