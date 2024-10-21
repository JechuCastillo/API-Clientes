package com.desempeno.CRUD.service;

import com.desempeno.CRUD.models.Cliente;
import com.desempeno.CRUD.repositories.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {
    //Tiene el repositorio que conecta con la BD
    private final ClientRepository clienteRepository;

    @Override
    public Optional<Cliente> getClientById(Long id) {
        //GET
        //Busca un determinado cliente en la BD, a traves del id
        return clienteRepository.findById(id);
    }

    @Override
    public List<Cliente> getClients() {
        //GET
        //Obtiene todos los clientes de la BD
        return clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> createClient(Cliente unCliente) {
        //POST
        //Gracias a @Builder podemos utilizar el patrón builder para instanciar una clase
        Cliente clienteParaGuardar = Cliente.builder()
                .password(unCliente.getPassword())
                .name(unCliente.getName())
                .lastName(unCliente.getLastName())
                .dni(unCliente.getDni())
                .email(unCliente.getEmail())
                .category(unCliente.getCategory())
                .isActive(true)
                .createdAt(ZonedDateTime.now())
                .updatedAt(ZonedDateTime.now())
                .build();
        return Optional.of(clienteRepository.save(clienteParaGuardar));
    }

    @Override
    public void deleteClient(Long id) {
        //DELETE
        clienteRepository.deleteById(id);
    }

    @Override
    public Optional<Cliente> updateClient(Long id, Cliente unCliente) {
        //PUT
        Cliente viejoCliente = clienteRepository.findById(id).get();
        if (viejoCliente!=null) {
            //Referenciamos al viejo cliente para actualizarlo al nuevo.
            Cliente nuevoCliente = viejoCliente;
            nuevoCliente.setName(unCliente.getName());
            nuevoCliente.setPassword(unCliente.getPassword());
            nuevoCliente.setLastName(unCliente.getLastName());
            nuevoCliente.setCategory(unCliente.getCategory());
            nuevoCliente.setUpdatedAt(ZonedDateTime.now());
            return Optional.of(clienteRepository.save(nuevoCliente));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Cliente> updateDataClient(Long id, Cliente unCliente) {
        //PATCH
        Optional clienteDesactualizado = clienteRepository.findById(id);

        if (clienteDesactualizado.isPresent()) {
            Cliente actualizar = (Cliente) clienteDesactualizado.get();
            actualizar.setCategory(unCliente.getCategory());
            actualizar.setUpdatedAt(ZonedDateTime.now());
            return Optional.of(clienteRepository.save(actualizar));
        } else {
            return Optional.empty();
        }
    }


}


