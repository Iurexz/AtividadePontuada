package com.aula.aula.controller;

import com.aula.aula.model.Funcionario;
import com.aula.aula.service.FuncionarioService;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



// Controlador responsável por gerenciar as operações relacionadas aos funcionários.
// Ele permite listar, salvar, atualizar e excluir funcionários.


@RequestMapping("/funcionarios")
@RestController
public class FuncionarioController {
    
    private FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @GetMapping
    public List<Funcionario> listarFuncionarios(){
        return funcionarioService.listarFuncionarios();
    }   

    @PostMapping
    public ResponseEntity<Map<String, Object>> salvar(@Valid @RequestBody Funcionario funcionario) {
        funcionarioService.salvar(funcionario);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("mensagem", "Funcionário " + funcionario.getNome() + " cadastrado com sucesso."));
    
    }

    @PutMapping
    public ResponseEntity<Map<String, Object>> atualizar(@Valid @RequestBody Funcionario funcionario) {
        funcionarioService.atualizar(funcionario);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("mensagem", "Funcionário " + funcionario.getNome() + " atualizado com sucesso."));

    }

    @DeleteMapping("/{email}")
    public ResponseEntity<Map<String, Object>> excluir(@PathVariable String email) {
        funcionarioService.excluir(email);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("mensagem","Funcionário excluído com sucesso."));
    }

}
    


