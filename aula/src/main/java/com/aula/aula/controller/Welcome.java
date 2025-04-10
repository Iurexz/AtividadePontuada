package com.aula.aula.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


// Aqui ficar o Bem Vindo conforme pedido.
@RestController
@RequestMapping("/")
public class Welcome {
    @GetMapping
    public String Welcome() {
        return "Bem Vindo(a) a minha API!";
    }

    @GetMapping("/dev")
    public String dev() {
        return "Desenvolvedor: Iure Silva.dev";
    }
}
