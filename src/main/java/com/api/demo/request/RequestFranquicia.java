package com.api.demo.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RequestFranquicia {
    private Long idFranquicia;
    private String nombre;
    private String direccion;
    private String telefono;
}
