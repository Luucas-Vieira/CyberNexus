package com.project.cybernexus.controllers;

import com.project.cybernexus.dtos.FaleConoscoDTO;
import com.project.cybernexus.models.FaleConoscoModel;
import com.project.cybernexus.services.FaleConoscoService;
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
public class FaleConoscoController {

    @Autowired
    private FaleConoscoService faleConoscoService;

    @Controller
    public class FaleConoscoNavegacao {
        @GetMapping("/fale-conosco")
        public String faleConosco() {
            return "faleConosco";
        }
    }


    @PostMapping("/fale-conosco/enviarEmail")
    public ResponseEntity<FaleConoscoModel> enviarEmail(@RequestBody @Valid FaleConoscoDTO faleConoscoDTO) {
        FaleConoscoModel faleConoscoModel = new FaleConoscoModel();
        BeanUtils.copyProperties(faleConoscoDTO, faleConoscoModel);
        faleConoscoService.enviarEmail(faleConoscoModel);
        return new ResponseEntity<>(faleConoscoModel, HttpStatus.CREATED);
    }
}
