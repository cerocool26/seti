package com.api.demo.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RequestSucursal {
    Long idSucursal;
    Long idFranquicia;
    String nombre;
}
