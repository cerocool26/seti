package com.api.demo.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseProductMaxStock {
    private String nombreProducto;
    private String nombreSucursal;
    private Integer stock;
}
