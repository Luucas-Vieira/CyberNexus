package com.project.cybernexus.controllers;

import com.project.cybernexus.dtos.MidiaDTO;
import com.project.cybernexus.services.MidiaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MidiaController {

    @Autowired
    private MidiaService midiaService;


    @PostMapping("/midia/nova-postagem")
    public ResponseEntity<MidiaDTO> criarPostagem(@RequestBody @Valid MidiaDTO midiaDTO) {
        midiaService.criarPostagem(midiaDTO);
        return new ResponseEntity<>(midiaDTO, HttpStatus.CREATED);
    }
}


