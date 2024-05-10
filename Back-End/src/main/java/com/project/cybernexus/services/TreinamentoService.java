package com.project.cybernexus.services;

import com.project.cybernexus.dtos.TreinamentoDTO;
import com.project.cybernexus.models.TreinamentoModel;
import com.project.cybernexus.repositories.TreinamentoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TreinamentoService {

    @Autowired
    private TreinamentoRepository treinamentoRepository;

    public void enviarAula(TreinamentoDTO treinamentoDTO) {
        TreinamentoModel treinamentoModel = new TreinamentoModel();
        BeanUtils.copyProperties(treinamentoDTO, treinamentoModel);
        treinamentoRepository.save(treinamentoModel);
    }
}
