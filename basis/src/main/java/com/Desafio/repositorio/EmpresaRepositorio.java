package com.Desafio.repositorio;

import com.Desafio.modelo.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepositorio  extends JpaRepository<Empresa, Integer> {

}
