package com.Desafio.servico;

import com.Desafio.modelo.Funcionario;
import com.Desafio.repositorio.FuncionarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioServico {
    @Autowired
    FuncionarioRepositorio funcionarioRepositorio;

    public List<Funcionario> listarFuncionarios(){
        return funcionarioRepositorio.findAll();
    }

    public void excluir(int id){
        funcionarioRepositorio.deleteById(id);
    }

    public Optional<Funcionario> buscaId(int id) {
        return funcionarioRepositorio.findById(id);
    }
    public Funcionario alterar(Funcionario funcionario) {
        return funcionarioRepositorio.save(funcionario);
    }

    public Funcionario cadastrar(Funcionario funcionario) {
        return funcionarioRepositorio.save(funcionario);
    }

}
