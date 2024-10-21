package com.desempeno.CRUD.controller;

import com.desempeno.CRUD.models.Cliente;
import com.desempeno.CRUD.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //Declara que esta clase sera un controlador
@RequiredArgsConstructor //Crea los constructores con los argumentos requeridos (@NonNull)
@RequestMapping("/api/clientes") //Mapea las solicitudes http a la url con este path
public class ClienteController {

    //El controlador usara el servicio para accerder a la BD.
    private final ClienteService clienteService;

    @GetMapping
    public List<Cliente> getClientes() {
        return clienteService.getClients();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClient(@PathVariable Long id) {
        Cliente unCliente = clienteService.getClientById(id).orElseThrow(() -> new RuntimeException("El usuario no fue encontrado"));
        return ResponseEntity.ok(unCliente);
    }

    @PostMapping
    public ResponseEntity<Cliente> createClient(@RequestBody Cliente unCliente) {
        Cliente nuevoCliente = clienteService.createClient(unCliente).orElseThrow(() -> new RuntimeException("Error al crear el nuevo usuario"));
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoCliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        clienteService.deleteClient(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> updateClient(@PathVariable Long id, @RequestBody Cliente unCliente) {
        Cliente clienteActualizado = clienteService.updateClient(id, unCliente).orElseThrow(() -> new RuntimeException("Problemas al actualizar el usuario"));
        return ResponseEntity.ok(clienteActualizado);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Cliente> updateCategory(@PathVariable Long id, @RequestBody Cliente unCliente) {
        Cliente clienteActualizado = clienteService.updateDataClient(id, unCliente).orElseThrow(() -> new RuntimeException("Problemas para actualizar la categoria del cliente"));
        return ResponseEntity.ok(clienteActualizado);
    }


}
