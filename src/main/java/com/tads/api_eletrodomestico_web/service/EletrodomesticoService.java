package com.tads.api_eletrodomestico_web.service;

import com.tads.api_eletrodomestico_web.domain.Eletrodomestico;
import com.tads.api_eletrodomestico_web.repository.EletrodomesticoRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EletrodomesticoService {
    private final EletrodomesticoRepository eletrodomesticoRepository;

    public EletrodomesticoService(EletrodomesticoRepository eletrodomesticoRepository) {
        this.eletrodomesticoRepository = eletrodomesticoRepository;
    }

    public List<Eletrodomestico> listProdutosNotDeleted(){
        return eletrodomesticoRepository.listProdutosNotDeleted();
    }

    public void createProduto(Eletrodomestico eletrodomestico){
        eletrodomesticoRepository.save(eletrodomestico);
    }
    public Eletrodomestico findById(Long id){
        Optional<Eletrodomestico> eletrodomesticoOptional = eletrodomesticoRepository.findById(id);
        return eletrodomesticoOptional.orElse(null);
    }

    public void updateProduto(Eletrodomestico eletrodomestico){
        eletrodomesticoRepository.saveAndFlush(eletrodomestico);
    }
    public void deleteProduto(Long id){
        Eletrodomestico produto = eletrodomesticoRepository.findById(id).get();
        Date date = new Date();

        if(produto != null){
            produto.setDeleted(date);
            updateProduto(produto);
        }
    }
}
