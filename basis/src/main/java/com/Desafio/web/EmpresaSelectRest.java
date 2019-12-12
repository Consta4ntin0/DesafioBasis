package com.Desafio.web;

import com.Desafio.servico.DTO.EmpresaSelectDTO;
import com.Desafio.servico.impl.EmpresaServicoSelectDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class EmpresaSelectRest {

    @Autowired
    EmpresaServicoSelectDTO empresaServico;

    @GetMapping(value="/empresasDto")
    public ResponseEntity<Collection<EmpresaSelectDTO>> buscarTodasEmpresa() {
        Collection<EmpresaSelectDTO> empresaCadastradas = empresaServico.listarEmpresas();
        return new ResponseEntity<>(empresaCadastradas, HttpStatus.OK);
    }

}
