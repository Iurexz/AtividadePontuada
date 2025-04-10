package com.aula.aula.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aula.aula.model.Funcionario;

// Repositório responsável por gerenciar as operações de persistência dos funcionários.
// Usa a interface para fornecer os métodos para o CRUD
@Repository
    
    public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>
    {Optional<Funcionario> findByCpf(String cpf);}

