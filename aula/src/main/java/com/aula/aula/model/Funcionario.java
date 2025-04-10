package com.aula.aula.model;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;


// Lombok é uma biblioteca que gera os métodos getters e setters automaticamente, evitando a necessidade de escrever manualmente.
// Relações das tabelas e dados da tabela Funcionario, onde tem as obrigatoriedades dos campos.
@Entity
@Data
public class Funcionario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O campo nome é obrigatório")
    private String nome;

    @NotBlank(message = "O campo CPF é obrigatório")
    @Size(min = 11, max = 11, message = "O CPF deve conter 11 dígitos")
    private String cpf;

    @NotBlank(message = "O campo data de nascimento é obrigatório")
    private String dataNascimento;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "O campo sexo é obrigatório")
    private Sexo sexo;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "O campo setor é obrigatório")
    private Setor setor;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "O campo estado civil é obrigatório")
    private EstadoCivil estadoCivil;
    
    @NotNull(message = "O salário é obrigatório")
    @Min(value = 0, message = "O salário deve ser maior ou igual a 0")
    private Double salario;

    @NotBlank(message = "O campo email é obrigatório")
    @Email(message = "O campo email deve ser um email válido")
    private String email;


    @OneToOne(cascade = CascadeType.ALL)
    @NotNull(message = "O campo endereço é obrigatório")
    private Endereco endereco;   
}

// Dev: Iure Silva.dev