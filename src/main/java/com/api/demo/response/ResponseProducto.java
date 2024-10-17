package com.api.demo.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResponseProducto {

    private Long idProducto;
    private Long idSucursal;
    private String nombre;
    private Integer stock;
}
