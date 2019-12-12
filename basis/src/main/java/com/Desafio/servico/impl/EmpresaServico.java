package com.Desafio.servico.impl;

import com.Desafio.modelo.Empresa;
import com.Desafio.repositorio.EmpresaRepositorio;
import com.Desafio.servico.DTO.EmpresaListDTO;
import com.Desafio.servico.mapper.ListagemEmpresaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmpresaServico {

    @Autowired
    EmpresaRepositorio empresaRepositorio;

    @Autowired
    ListagemEmpresaMapper listagemEmpresaMapper;

    public Empresa cadastrar(Empresa empresa){
        return empresaRepositorio.save(empresa);
    }

    public List<EmpresaListDTO> listarEmpresas(){
        List<EmpresaListDTO> dto = listagemEmpresaMapper.toDto(empresaRepositorio.findAll());
        return dto;
    }

    public void excluir(int cod){
        empresaRepositorio.deleteById(cod);
    }


    public Empresa alterar(Empresa empresa) {
        return empresaRepositorio.save(empresa);
    }

}
