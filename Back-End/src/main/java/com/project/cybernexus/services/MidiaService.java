package com.project.cybernexus.services;

import com.project.cybernexus.models.MidiaModel;

import com.project.cybernexus.repositories.MidiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MidiaService {

    @Autowired
    private MidiaRepository midiaRepository;

    public void criarPostagem(MidiaModel midiaModel) {
    }
}
