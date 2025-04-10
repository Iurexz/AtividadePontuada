package com.aula.aula.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


// Dados da tabela Endereco, onde tem as obrigatoriedades dos campos.
//Que está sendo usado na tabela de Funcionários como 1 para 1.
@Entity
@Data
@Table(name = "tab_endereco")
public class Endereco {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O campo logradouro é obrigatório")
    private String logradouro;

    @NotBlank(message = "O campo número é obrigatório")
    private String numero;

    @NotBlank(message = "O campo complemento é obrigatório")
    private String complemento;

    @NotNull(message = "O campo cidade é obrigatório")
    private String cidade;

    
}
