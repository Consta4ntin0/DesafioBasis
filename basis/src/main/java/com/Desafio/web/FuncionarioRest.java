package com.Desafio.web;

import com.Desafio.modelo.Funcionario;
import com.Desafio.servico.DTO.FuncionarioCreateDto;
import com.Desafio.servico.DTO.FuncionarioListDTO;
import com.Desafio.servico.impl.FuncionarioServico;
import org.jetbrains.annotations.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@Controller
public class FuncionarioRest {

    @Autowired
    private final FuncionarioServico funcionarioServico;

    @Contract(pure = true)
    FuncionarioRest(FuncionarioServico funcionarioServico){
        this.funcionarioServico = funcionarioServico;
    }

    @GetMapping(path = "/funcionarios")
    public ResponseEntity<List<FuncionarioListDTO>> buscarTodosFuncionarios() {
        try {
        List<FuncionarioListDTO> funcionariosCadastrados = funcionarioServico.listarFuncionarios();
        return new ResponseEntity<>(funcionariosCadastrados, HttpStatus.OK);
        }catch (ResponseStatusException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/funcionario/{cod}")
    public FuncionarioCreateDto listarId(@PathVariable("cod") int id) {
        System.out.println(funcionarioServico.buscaId(id).toString());
        return funcionarioServico.buscaId(id);
    }

    @PutMapping(value = "/funcionario/{cod}")
    public ResponseEntity<Funcionario>  editar(@RequestBody FuncionarioCreateDto f,
                                               @PathVariable("cod") int cod){
        f.setCod(cod);
        funcionarioServico.alterar(f);
        return new ResponseEntity<>( HttpStatus.OK);
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
    public ResponseEntity adicionar(@RequestBody FuncionarioCreateDto funcionarioCreateDto) {
        funcionarioServico.cadastrar(funcionarioCreateDto);
        return new ResponseEntity(HttpStatus.OK);
    }

}
