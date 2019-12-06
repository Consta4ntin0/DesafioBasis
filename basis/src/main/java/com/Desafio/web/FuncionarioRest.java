package com.Desafio.web;

import com.Desafio.modelo.Funcionario;
import com.Desafio.servico.DTO.FuncionarioDTO;
import com.Desafio.servico.DTO.FuncionarioEditDTO;
import com.Desafio.servico.impl.FuncionarioServico;
import com.Desafio.servico.mapper.EditarFuncionarioMapper;
import com.Desafio.servico.mapper.ListagemFuncionarioMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@Controller
public class FuncionarioRest {
    private ListagemFuncionarioMapper mapper;
    private final FuncionarioServico funcionarioServico;

    FuncionarioRest(FuncionarioServico funcionarioServico){
        this.funcionarioServico = funcionarioServico;
    }

    @GetMapping(path = "/funcionarios")
    public ResponseEntity<List<FuncionarioDTO>> buscarTodosFuncionarios() {
        try {
        List<FuncionarioDTO> funcionariosCadastrados = funcionarioServico.listarFuncionarios();
        return new ResponseEntity<>(funcionariosCadastrados, HttpStatus.OK);
        }catch (ResponseStatusException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/funcionario/{cod}")
    public FuncionarioEditDTO listarId(@PathVariable("cod") int id) {
        return funcionarioServico.buscaId(id);
    }

    @PutMapping(value = "/funcionario/{cod}")
    public ResponseEntity<Funcionario>  editar(@RequestBody FuncionarioEditDTO f, @PathVariable("cod") int cod){
        try {
            return new ResponseEntity<>(funcionarioServico.alterar(f), HttpStatus.OK);
        }catch (ResponseStatusException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/funcionario/{cod}")
    public ResponseEntity<Void> delete(@PathVariable("cod") int cod) {
        try {
            funcionarioServico.excluir(cod);
            return new ResponseEntity(HttpStatus.OK);
        }catch (HttpStatusCodeException e){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value="/funcionario" )
    public void adicionar(@RequestBody FuncionarioEditDTO funcionarioDto) {
           funcionarioServico.cadastrar(funcionarioDto);
    }
}
