package com.api.demo.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResponseSucursal {
    Long idSucursal;
    Long idFranquicia;
    String nombre;
}
