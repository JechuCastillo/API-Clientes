package com.desempeno.CRUD.service;

import com.desempeno.CRUD.models.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    //Métodos que debe implementar la clase que implemente.
    List<Cliente> getClients();
    Optional<Cliente> getClientById(Long id);
    Optional<Cliente> createClient(Cliente unCliente);
    void deleteClient(Long id);
    Optional<Cliente> updateClient(Long id,Cliente unCliente);
    Optional<Cliente> updateDataClient(Long id,Cliente unCliente);
}
