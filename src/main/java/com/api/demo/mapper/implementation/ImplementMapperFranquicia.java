package com.api.demo.mapper.implementation;

import com.api.demo.mapper.MapperFranquicia;
import com.api.demo.model.Franquicia;
import com.api.demo.request.RequestFranquicia;
import com.api.demo.response.ResponseFranquicia;
import org.springframework.stereotype.Component;

@Component
public class ImplementMapperFranquicia implements MapperFranquicia {

    @Override
    public ResponseFranquicia franquiciaResponseMapper(Franquicia franquicia) {
        ResponseFranquicia response = new ResponseFranquicia();
        response.setNombre(franquicia.getNombre());
        response.setDireccion(franquicia.getDireccion());
        response.setTelefono(franquicia.getTelefono());

        return response;
    }

    @Override
    public Franquicia franquiciaRequestMapper(RequestFranquicia requestFranquicia){
        Franquicia franquicia = new Franquicia();
        franquicia.setNombre(requestFranquicia.getNombre());
        franquicia.setDireccion(requestFranquicia.getDireccion());
        franquicia.setTelefono(requestFranquicia.getTelefono());
        return  franquicia;
    }

}
