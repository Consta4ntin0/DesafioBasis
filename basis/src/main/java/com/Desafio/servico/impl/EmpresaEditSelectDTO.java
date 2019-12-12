package com.Desafio.servico.impl;

import com.Desafio.modelo.Empresa;
import com.Desafio.repositorio.EmpresaRepositorio;
import com.Desafio.servico.DTO.EmpresaListDTO;
import com.Desafio.servico.mapper.ListagemEmpresaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class EmpresaEditSelectDTO {

    @Autowired
    EmpresaRepositorio empresaRepositorio;

    @Autowired
    ListagemEmpresaMapper listagemEmpresaMapper;

    public EmpresaListDTO findById(int id){
        Optional<Empresa> emp =empresaRepositorio.findById(id) ;
        return listagemEmpresaMapper.toDto( emp.get() );
    }

}
