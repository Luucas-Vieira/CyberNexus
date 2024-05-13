package com.project.cybernexus.controllers;

import com.project.cybernexus.dtos.FaleConoscoDTO;
import com.project.cybernexus.services.FaleConoscoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@RestController
public class FaleConoscoController {

    @Autowired
    private FaleConoscoService faleConoscoService;


    @PostMapping("/fale-conosco/enviarEmail")
    public ResponseEntity<FaleConoscoDTO> enviarEmail(@RequestPart("faleConoscoDTO") @Valid FaleConoscoDTO faleConoscoDTO, @RequestPart("anexos") List<MultipartFile> anexos) {
        faleConoscoService.enviarEmail(faleConoscoDTO, anexos);
        return new ResponseEntity<>(faleConoscoDTO, HttpStatus.CREATED);
    }

}
