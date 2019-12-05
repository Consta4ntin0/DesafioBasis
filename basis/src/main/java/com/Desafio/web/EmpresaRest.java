package com.Desafio.web;

import com.Desafio.modelo.Empresa;
import com.Desafio.servico.impl.EmpresaServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class EmpresaRest {
    @Autowired
    EmpresaServico empresaServico;

    @RequestMapping(method= RequestMethod.GET, value="/empresas", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Empresa>> buscarTodasEmpresa() {
        Collection<Empresa> empresaCadastradas = empresaServico.listarEmpresas();
        return new ResponseEntity<>(empresaCadastradas, HttpStatus.OK);
    }

    @RequestMapping(method= RequestMethod.GET, value="/empresa/{cod}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Empresa> listarId(@PathVariable("cod") int id) {
        return empresaServico.buscaId(id);
    }

    @RequestMapping(method= RequestMethod.PUT, value="/empresa/{cod}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Empresa editar(@RequestBody Empresa e, @PathVariable("cod") int cod) {
        e.setCod(cod);
        return empresaServico.alterar(e);
    }

    @RequestMapping(method= RequestMethod.DELETE, value="/empresa/{cod}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> delete(@PathVariable("cod") int cod) {
        empresaServico.excluir(cod);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(method=RequestMethod.POST, value="/empresa", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void adicionar(@RequestBody Empresa funcionario) {
        System.out.println(funcionario.toString());
        empresaServico.cadastrar(funcionario);
    }
}
