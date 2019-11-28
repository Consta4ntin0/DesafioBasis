package com.Desafio.web;

import com.Desafio.modelo.Funcionario;
import com.Desafio.servico.FuncionarioServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class FuncionarioRest {
    @Autowired
    FuncionarioServico funcionarioServico;

    @RequestMapping(method = RequestMethod.GET, value="/funcionarios", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Funcionario>> buscarTodosFuncionarios() {
        Collection<Funcionario> funcionariosCadastrados = funcionarioServico.listarFuncionarios();
        System.out.println("Clientes Listados");
        return new ResponseEntity<>(funcionariosCadastrados, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value="/funcionario/{cod}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Funcionario> listarId(@PathVariable("cod") int id) {
        return funcionarioServico.buscaId(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value="/funcionario/{cod}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Funcionario editar(@RequestBody Funcionario f, @PathVariable("cod") int cod) {
        f.setCod(cod);
        return funcionarioServico.alterar(f);
    }

    @RequestMapping(method = RequestMethod.DELETE, value="/funcionario/{cod}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable("cod") int cod) {
        funcionarioServico.excluir(cod);
    }

    @RequestMapping(method = RequestMethod.POST, value="/funcionario", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void adicionar(@RequestBody Funcionario funcionario) {
        System.out.println(funcionario.toString());
        funcionarioServico.cadastrar(funcionario);
    }

}
