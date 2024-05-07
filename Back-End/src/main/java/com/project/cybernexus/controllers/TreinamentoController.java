package com.project.cybernexus.controllers;

import com.project.cybernexus.dtos.TreinamentoDTO;
import com.project.cybernexus.models.MidiaModel;
import com.project.cybernexus.models.TreinamentoModel;
import com.project.cybernexus.services.TreinamentoService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TreinamentoController {

    @Autowired
    private TreinamentoService treinamentoService;

    @Controller
    public class TreinamentoNavegacao {
        @GetMapping("/treinamento")
        public String Treinamento() {
            return "treinamento";
        }
    }

    @PostMapping("/treinamento/nova-aula")
    public ResponseEntity<TreinamentoModel> enviarAula(@RequestBody @Valid TreinamentoDTO treinamentoDTO) {
        TreinamentoModel treinamentoModel = new TreinamentoModel();
        BeanUtils.copyProperties(treinamentoDTO, treinamentoModel);
        treinamentoService.enviarAula(treinamentoModel);
        return new ResponseEntity<>(treinamentoModel, HttpStatus.CREATED);
    }
}
