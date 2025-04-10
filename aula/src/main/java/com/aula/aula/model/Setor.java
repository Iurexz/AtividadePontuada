package com.aula.aula.model;
import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;


// Enum Setor com os setores disponíveis na empresa, e o String nome tem a função de retornar o nome do setor mais legível.
public enum Setor {
    ENGENHARIA("Engenharia"),
    SAUDE("Saúde"),
    JURIDICO("Jurídico");

    private final String nome;

    Setor(String nome) {
        this.nome = nome;
    }

    @JsonValue
    @Override
    public String toString() {
        return nome; 
    }

    @JsonCreator
public static Setor fromValue(String value) {
    for (Setor setor : Setor.values()) {
        if (setor.name().equalsIgnoreCase(value)) {
            return setor;
        }
    }
    throw new IllegalArgumentException("O valor '" + value + "' não é válido para o campo Setor. Valores aceitos: " +
            Arrays.toString(Arrays.stream(Setor.values()).map(Setor::name).toArray()));
}
}