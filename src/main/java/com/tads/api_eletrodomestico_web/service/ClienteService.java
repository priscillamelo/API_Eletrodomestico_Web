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

    public List<Cliente> listClients() {
        return repository.findAll();
    }

    public void addClient(Cliente cliente) {
        repository.save(cliente);
    }
    public Cliente findById(Long id){
        Optional<Cliente> clienteOptional = repository.findById(id);
        return clienteOptional.orElse(null);
    }

    public void updateClient(Cliente cliente){
        repository.saveAndFlush(cliente);
    }
    public void deleteClient(Long id){
        repository.deleteById(id);
    }
}
