package com.Desafio.repositorio;

import com.Desafio.modelo.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepositorio  extends JpaRepository<Funcionario, Integer> {

}