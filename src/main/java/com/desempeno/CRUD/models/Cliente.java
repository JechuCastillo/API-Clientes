package com.desempeno.CRUD.models;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.ZonedDateTime;

@Entity (name = "crud_client") //Declara que sera una entidad en la BD
@Data //Getters y Setters
@NoArgsConstructor //Crea el constructor sin argumentos
@AllArgsConstructor //Crea constructor con todos los argumentos
@Builder //Patron
@Table(name = "crud_clientes")
public class Cliente {
    @Id //Representa la primary key de la BD
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Obliga a que el id sea uno sucesivo de otro
    private long id;



    @Column(name = "password")//Declara que sera una columna en la BD
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) //Ocultas el password cuando se muestra el JSON
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "dni", unique = true) //Constraints para la BD
    private String dni;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "category")
    private String category;

    @Column(name = "is_active")
    private boolean isActive;

    @CreatedDate
    @Column(name = "created_at")
    private ZonedDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private ZonedDateTime updatedAt;

    @Version
    private Integer version;

}

