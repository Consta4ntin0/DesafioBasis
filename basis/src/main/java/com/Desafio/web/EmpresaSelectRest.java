package com.Desafio.web;

import com.Desafio.modelo.Empresa;
import com.Desafio.servico.DTO.EmpresaSelectDTO;
import com.Desafio.servico.impl.EmpresaServico;
import com.Desafio.servico.impl.EmpresaServicoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class EmpresaSelectRest {
    @Autowired
    EmpresaServicoDTO empresaServico;

    @GetMapping(value="/empresasDto")
    public ResponseEntity<Collection<EmpresaSelectDTO>> buscarTodasEmpresa() {
        Collection<EmpresaSelectDTO> empresaCadastradas = empresaServico.listarEmpresas();
        return new ResponseEntity<>(empresaCadastradas, HttpStatus.OK);
    }
}
