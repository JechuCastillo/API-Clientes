package com.desempeno.CRUD.repositories;

import com.desempeno.CRUD.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
//Conexión con la BD
public interface ClientRepository extends JpaRepository <Cliente, Long>{
}
