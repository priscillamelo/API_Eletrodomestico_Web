package com.tads.api_eletrodomestico_web.service;

import com.tads.api_eletrodomestico_web.domain.Endereco;
import com.tads.api_eletrodomestico_web.repository.EnderecoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {
    EnderecoRepository repository;
    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.repository = enderecoRepository;
    }

    public List<Endereco> list(){
        return repository.findAll();
    }
    public Endereco addEnd(Endereco endereco) {
        repository.save(endereco);
        return endereco;
    }
    public Optional<Endereco> findById(Long id){
        return repository.findById(id);
    }

    public Endereco updateEnd(Endereco endereco){
       return repository.saveAndFlush(endereco);
    }
    public void deleteEnd(Long id){
        repository.deleteById(id);
    }
}
