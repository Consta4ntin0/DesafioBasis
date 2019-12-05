package com.Desafio.servico.impl;

import com.Desafio.modelo.Empresa;
import com.Desafio.repositorio.EmpresaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaServico {
    @Autowired
    EmpresaRepositorio empresaRepositorio;

    public Empresa cadastrar(Empresa empresa){
        return empresaRepositorio.save(empresa);
    }
    public List<Empresa> listarEmpresas(){
        return empresaRepositorio.findAll();
    }
    public void excluir(int cod){
        empresaRepositorio.deleteById(cod);
    }
    public Optional<Empresa> buscaId(int id) {
        return empresaRepositorio.findById(id);
    }
    public Empresa alterar(Empresa empresa) {
        return empresaRepositorio.save(empresa);
    }
}
