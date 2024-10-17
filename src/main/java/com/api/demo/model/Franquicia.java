package com.api.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "franquicia")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Franquicia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_franquicia",unique = true)
    private Long idFranquicia;

    private String nombre;

    private String direccion;

    private String telefono;

    @OneToMany(mappedBy="franquicia")
    private Set<Sucursal> sucursales;

}
