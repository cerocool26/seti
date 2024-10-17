package com.api.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "producto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_producto",unique = true)
    private Long idProducto;

    private String nombre;

    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "id_sucursal")
    private Sucursal sucursal;
}
