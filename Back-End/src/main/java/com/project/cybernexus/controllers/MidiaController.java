package com.project.cybernexus.controllers;

import com.project.cybernexus.dtos.MidiaDTO;
import com.project.cybernexus.models.MidiaModel;
import com.project.cybernexus.services.MidiaService;
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
public class MidiaController {

    @Autowired
    private MidiaService midiaService;

    @Controller
    public class MidiaNavegacao {
        @GetMapping("/midia")
        public String Midia() {
            return "midia";
        }
    }

    @PostMapping("/midia/nova-postagem")
    public ResponseEntity<MidiaModel> criarPostagem(@RequestBody @Valid MidiaDTO midiaDTO) {
        MidiaModel midiaModel = new MidiaModel();
        BeanUtils.copyProperties(midiaDTO, midiaModel);
        midiaService.criarPostagem(midiaModel);
        return new ResponseEntity<>(midiaModel, HttpStatus.CREATED);
    }
}


