package com.Desafio.servico.impl;

import com.Desafio.modelo.Funcionario;
import com.Desafio.repositorio.FuncionarioRepositorio;
import com.Desafio.servico.DTO.FuncionarioDTO;
import com.Desafio.servico.DTO.FuncionarioEditDTO;
import com.Desafio.servico.mapper.EditarFuncionarioMapper;
import com.Desafio.servico.mapper.ListagemFuncionarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioServico {

    private final FuncionarioRepositorio funcionarioRepositorio;

    @Autowired
    private  ListagemFuncionarioMapper funcionarioMapper;
    @Autowired
    private EditarFuncionarioMapper editarFuncionarioMapper;

    FuncionarioServico(FuncionarioRepositorio funcionarioRepositorio){
        this.funcionarioRepositorio = funcionarioRepositorio;
    }
    public List<FuncionarioDTO> listarFuncionarios(){
        return funcionarioMapper.toDto(this.funcionarioRepositorio.findAll());
    }

    public void excluir(int id){
        System.out.println(id);
        funcionarioRepositorio.deleteById(id);
    }

    public FuncionarioEditDTO buscaId(int cod) {
        Optional<Funcionario> func = funcionarioRepositorio.findById(cod);
        return editarFuncionarioMapper.toDto( func.get() );
    }
    public Funcionario alterar(FuncionarioEditDTO funcionarioDto) {
        Funcionario func = editarFuncionarioMapper.toEntity(funcionarioDto);
        System.out.println(func.getEmpresa().getNome()+" - "+func.getEmpresa().getCod());
        return funcionarioRepositorio.save(func);
    }

    public Funcionario cadastrar(FuncionarioEditDTO funcionarioDto) {
        Funcionario  funcionario = editarFuncionarioMapper.toEntity(funcionarioDto);
        return funcionarioRepositorio.save(funcionario);
    }

}
