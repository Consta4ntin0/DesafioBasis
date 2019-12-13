package com.Desafio.web;

import com.Desafio.modelo.Empresa;
import com.Desafio.servico.DTO.EmpresaListDTO;
import com.Desafio.servico.impl.EmpresaEditSelectDTO;
import com.Desafio.servico.impl.EmpresaServico;
import com.Desafio.web.error.CustomErrorType;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;
import java.util.Collection;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class EmpresaRest {

    @Autowired
    EmpresaServico empresaServico;

    @Autowired
    EmpresaEditSelectDTO empresaEditSelectDTO;

    @GetMapping(value="/empresas")
    public ResponseEntity<Collection<EmpresaListDTO>> buscarTodasEmpresa() {
        Collection<EmpresaListDTO> empresaCadastradas = empresaServico.listarEmpresas();
        return new ResponseEntity<>(empresaCadastradas, HttpStatus.OK);
    }

    @GetMapping(value="/empresa/{cod}")
    public EmpresaListDTO listarId(@PathVariable("cod") int id) {
        return empresaEditSelectDTO.findById(id);
    }

    @PutMapping(value="/empresa/{cod}")
    public ResponseEntity editar(@NotNull @RequestBody Empresa emp, @PathVariable("cod") int cod) {
        try{
        emp.setCod(cod);
        empresaServico.alterar(emp);
        return new ResponseEntity(HttpStatus.OK);
    } catch (ValidationException e) {
        return new ResponseEntity(new CustomErrorType("CNPJ Invalido"), HttpStatus.BAD_REQUEST);
    }
    }

    @DeleteMapping(value="/empresa/{cod}")
    public ResponseEntity<Void> delete(@PathVariable("cod") int cod) {
        empresaServico.excluir(cod);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping(value="/empresa")
    public ResponseEntity adicionar(@RequestBody Empresa funcionario) {
        try {
            empresaServico.cadastrar(funcionario);
            return new ResponseEntity(HttpStatus.OK);
        } catch (
                ValidationException e) {
            return new ResponseEntity(new CustomErrorType("CNPJ Invalido"), HttpStatus.BAD_REQUEST);
        }
    }

}
