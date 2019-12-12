package com.Desafio.servico.impl;

import com.Desafio.modelo.Endereco;
import com.Desafio.repositorio.EnderecoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoServico {

    @Autowired
    EnderecoRepositorio enderecoRepositorio;

    public Endereco cadastrar(Endereco end) {
        Endereco endereco = end;
        System.out.println(endereco.getCod());
        return enderecoRepositorio.save(endereco);
    }

    public Endereco alterar(Endereco end) {
        return enderecoRepositorio.save(end);
    }

}
