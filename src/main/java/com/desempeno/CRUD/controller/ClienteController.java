package com.desempeno.CRUD.controller;

import com.desempeno.CRUD.exception.BadRequestException;
import com.desempeno.CRUD.exception.NotFoundException;
import com.desempeno.CRUD.models.Cliente;
import com.desempeno.CRUD.service.ClienteService;
import com.desempeno.CRUD.validation.CodigoError;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@Slf4j
@RestController //Declara que esta clase sera un controlador
@RequiredArgsConstructor //Crea los constructores con los argumentos requeridos (@NonNull o final)
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
        Cliente unCliente = clienteService.getClientById(id).orElseThrow(() -> new NotFoundException(CodigoError.CLIENTE_NO_ENCONTRADO.getCode(),
                CodigoError.CLIENTE_NO_ENCONTRADO.getDescription(id)));
        log.info("El cliente con ID {} es: {}",id,unCliente);
        return ResponseEntity.ok(unCliente);
    }

    @PostMapping
    public ResponseEntity<Cliente> createClient(@RequestBody Cliente unCliente) {
        Cliente nuevoCliente = clienteService.createClient(unCliente).orElseThrow(() -> new NotFoundException(CodigoError.CLIENTE_NO_PUDO_SER_CREADO.getCode(),
                CodigoError.CLIENTE_NO_PUDO_SER_CREADO.getDescription(unCliente.getEmail())));
        log.info("El cliente con email {} fue creado con exito",unCliente.getEmail());
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoCliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        clienteService.deleteClient(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> updateClient(@PathVariable Long id, @RequestBody Cliente unCliente) {
        Cliente clienteActualizado = clienteService.updateClient(id, unCliente).orElseThrow(() -> new NotFoundException(CodigoError.CLIENTE_NO_PUDO_SER_ACTUALIZADO.getCode(),
                CodigoError.CLIENTE_NO_ENCONTRADO.getDescription(id)));
        log.info("El cliente con id {} fue actualizado con exito",id);
        return ResponseEntity.ok(clienteActualizado);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Cliente> updateCategory(@PathVariable Long id, @RequestBody Cliente unCliente) {
        Cliente clienteActualizado = clienteService.updateDataClient(id, unCliente).orElseThrow(() -> new NotFoundException(CodigoError.CATEGORIA_DE_CLIENTE_NO_PUDO_SER_ACTUALIZADO.getCode(),
                CodigoError.CATEGORIA_DE_CLIENTE_NO_PUDO_SER_ACTUALIZADO.getDescription(id)));
        log.info("Se actualizo la categoría del cliente con id {} exitosamente",id);
        return ResponseEntity.ok(clienteActualizado);
    }

    /*QUERYS PERSONALIZADAS*/
    @GetMapping("/activos")
    public List<Cliente> getClientsActive(){
        return clienteService.getClientsActive();
    }

    @GetMapping("/activos/{id}")
    public ResponseEntity<Cliente> getClientActiveById(@PathVariable Long id){
        Cliente aClient= clienteService.getClientActiveById(id).orElseThrow(()-> new NotFoundException(CodigoError.CLIENTE_ACTIVO_POR_ID_NO_ENCONTRADO.getCode(),
                CodigoError.CLIENTE_ACTIVO_POR_ID_NO_ENCONTRADO.getDescription(id)));
        log.info("El cliente con id {} es: {}",id,aClient);
        return ResponseEntity.ok(aClient);
    }

    @DeleteMapping("/activos/{id}")
    public ResponseEntity<Void> logicalDelete(@PathVariable Long id){
        clienteService.logicalDelete(id);
        return ResponseEntity.noContent().build();
    }



}
