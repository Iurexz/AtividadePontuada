package com.aula.aula.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import com.aula.aula.model.Funcionario;
import com.aula.aula.repository.FuncionarioRepository;


// Repositório responsável por gerenciar as operações de persistência dos funcionários.
// Aqui são os métodos que vão fazer as operações CRUD (Create, Read, Update e Delete) conforme pedido.
// Parte principal e importante do projeto.
@Validated
@Service
public class FuncionarioService {
    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public List<Funcionario> listarFuncionarios() {
        return funcionarioRepository.findAll();
    }

    public Funcionario salvar(Funcionario funcionario) {
        if (funcionarioRepository.findByCpf(funcionario.getCpf()).isPresent()) {
            throw new RuntimeException("Cpf já cadastrado");
        }
        return funcionarioRepository.save(funcionario);
    }

    public Funcionario atualizar(Funcionario funcionario) {
        Funcionario funcionarioAtualizar = funcionarioRepository.findByCpf(funcionario.getCpf())
                .orElseThrow(() -> new IllegalArgumentException("Funcionário não encontrado"));

        funcionarioAtualizar.setNome(funcionario.getNome());
        funcionarioAtualizar.setCpf(funcionario.getCpf());
        funcionarioAtualizar.setDataNascimento(funcionario.getDataNascimento());
        funcionarioAtualizar.setSexo(funcionario.getSexo());
        funcionarioAtualizar.setSetor(funcionario.getSetor());
        funcionarioAtualizar.setEstadoCivil(funcionario.getEstadoCivil());
        funcionarioAtualizar.setSalario(funcionario.getSalario());
        funcionarioAtualizar.setEmail(funcionario.getEmail());
        funcionarioAtualizar.setEndereco(funcionario.getEndereco());
        
        return funcionarioRepository.save(funcionarioAtualizar);
    }

    public void excluir(String cpf) {
        Funcionario funcionarioExcluir = funcionarioRepository.findByCpf(cpf)
                .orElseThrow(() -> new IllegalArgumentException("Funcionário não encontrado"));
        funcionarioRepository.delete(funcionarioExcluir);
    }
}
