package com.api.demo.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RequestProducto {
    private Long idProducto;
    private Long idSucursal;
    private String nombre;
    private Integer stock;
}
