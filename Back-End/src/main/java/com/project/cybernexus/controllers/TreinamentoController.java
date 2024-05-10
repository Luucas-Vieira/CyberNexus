package com.project.cybernexus.controllers;

import com.project.cybernexus.dtos.TreinamentoDTO;
import com.project.cybernexus.services.TreinamentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TreinamentoController {

    @Autowired
    private TreinamentoService treinamentoService;


    @PostMapping("/treinamento/nova-aula")
    public ResponseEntity<TreinamentoDTO> enviarAula(@RequestBody @Valid TreinamentoDTO treinamentoDTO) {
        treinamentoService.enviarAula(treinamentoDTO);
        return new ResponseEntity<>(treinamentoDTO, HttpStatus.CREATED);
    }
}
