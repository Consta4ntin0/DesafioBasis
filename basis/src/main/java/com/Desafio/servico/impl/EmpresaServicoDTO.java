package com.Desafio.servico.impl;

import com.Desafio.modelo.Empresa;
import com.Desafio.repositorio.EmpresaRepositorio;
import com.Desafio.servico.DTO.EmpresaSelectDTO;
import com.Desafio.servico.mapper.SelectEmpresasMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaServicoDTO {
    @Autowired
    EmpresaRepositorio empresaRepositorio;
    @Autowired
    SelectEmpresasMapper selectEmpresasMapper;

    public List<EmpresaSelectDTO> listarEmpresas(){
        return selectEmpresasMapper.toDto(empresaRepositorio.findAll());
    }

}
