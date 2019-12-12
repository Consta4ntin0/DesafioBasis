package com.Desafio.servico.impl;

import com.Desafio.modelo.Endereco;
import com.Desafio.modelo.Funcionario;
import com.Desafio.repositorio.FuncionarioRepositorio;
import com.Desafio.servico.DTO.FuncionarioCreateDto;
import com.Desafio.servico.DTO.FuncionarioListDTO;
import com.Desafio.servico.mapper.EditarFuncionarioMapper;
import com.Desafio.servico.mapper.ListagemFuncionarioMapper;
import org.jetbrains.annotations.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioServico {

    @Autowired
    private final FuncionarioRepositorio funcionarioRepositorio;

    @Autowired
    private final EnderecoServico enderecoServico;

    @Autowired
    private final ListagemFuncionarioMapper funcionarioMapper;

    @Autowired
    private final EditarFuncionarioMapper editarFuncionarioMapper;

    @Contract(pure = true)
    FuncionarioServico(FuncionarioRepositorio funcionarioRepositorio, EnderecoServico enderecoServico, ListagemFuncionarioMapper funcionarioMapper, EditarFuncionarioMapper editarFuncionarioMapper){
        this.funcionarioRepositorio = funcionarioRepositorio;
        this.enderecoServico = enderecoServico;
        this.funcionarioMapper = funcionarioMapper;
        this.editarFuncionarioMapper = editarFuncionarioMapper;
    }

    public List<FuncionarioListDTO> listarFuncionarios(){
        return funcionarioMapper.toDto(this.funcionarioRepositorio.findAll());
    }

    public void excluir(int id){
        System.out.println(id);
        funcionarioRepositorio.deleteById(id);
    }

    public FuncionarioCreateDto buscaId(int cod) {
        Optional<Funcionario> func = funcionarioRepositorio.findById(cod);
        return editarFuncionarioMapper.toDto( func.get() );
    }

    public Funcionario alterar(FuncionarioCreateDto funcionarioDto) {
        Funcionario func = editarFuncionarioMapper.toEntity(funcionarioDto);
        Endereco endereco = func.getEndereco();
        endereco.setFuncionario(func);
        enderecoServico.alterar(endereco);
        funcionarioRepositorio.save(func);
        return func;
    }

    public Funcionario cadastrar(FuncionarioCreateDto funcionarioDto) {
        Funcionario  funcionario = editarFuncionarioMapper.toEntity(funcionarioDto);
        Endereco endereco = funcionario.getEndereco();
        endereco.setFuncionario(funcionario);
        enderecoServico.cadastrar(endereco);
        funcionarioRepositorio.save(funcionario);
        return funcionario;
    }

}
