package com.tads.api_eletrodomestico_web.service;

import com.tads.api_eletrodomestico_web.domain.Cliente;
import com.tads.api_eletrodomestico_web.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    ClienteRepository repository;
    public ClienteService(ClienteRepository clienteRepository) {
        this.repository = clienteRepository;
    }

    public List<Cliente> list(){
        return repository.findAll();
    }
    public Cliente addClient(Cliente cliente) {
        repository.save(cliente);
        return cliente;
    }
    public Optional<Cliente> findById(Long id){
        return repository.findById(id);
    }

    public void updateClient(Cliente cliente){
        repository.saveAndFlush(cliente);
    }
    public void deleteClient(Long id){
        repository.deleteById(id);
    }
}
