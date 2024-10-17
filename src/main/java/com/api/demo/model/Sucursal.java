package com.api.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "sucursal")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Sucursal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="id_sucursal",unique = true)
    private Long idSucursal;

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id_franquicia")
    private Franquicia franquicia;

    @OneToMany(mappedBy="sucursal")
    private Set<Producto> productos;

}
