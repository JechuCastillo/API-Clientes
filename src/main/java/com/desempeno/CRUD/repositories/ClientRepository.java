package com.desempeno.CRUD.repositories;

import com.desempeno.CRUD.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//Conexión con la BD
@Repository
public interface ClientRepository extends JpaRepository <Cliente, Long>{

    @Query("SELECT c FROM Cliente c WHERE c.isActive=true")
    List<Cliente> getClientsActive();

    @Query("SELECT c FROM Cliente c WHERE :id=c.id AND c.isActive=true")
    Optional<Cliente> getClientActiveById(@Param("id") Long id);


}
