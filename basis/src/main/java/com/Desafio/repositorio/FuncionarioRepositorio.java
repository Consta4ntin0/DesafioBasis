package com.Desafio.repositorio;

import com.Desafio.modelo.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepositorio  extends JpaRepository<Funcionario, Integer> {

}