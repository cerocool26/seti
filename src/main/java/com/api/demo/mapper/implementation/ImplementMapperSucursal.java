package com.api.demo.mapper.implementation;

import com.api.demo.mapper.MapperSucursal;
import com.api.demo.model.Franquicia;
import com.api.demo.model.Sucursal;
import com.api.demo.request.RequestSucursal;
import com.api.demo.response.ResponseSucursal;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ImplementMapperSucursal implements MapperSucursal {

    @Override
    public ResponseSucursal sucursalResponsetMapper(Sucursal sucursal){
        ResponseSucursal responseSucursal = new ResponseSucursal();
        responseSucursal.setIdSucursal(sucursal.getIdSucursal());
        responseSucursal.setNombre(sucursal.getNombre());
        responseSucursal.setIdFranquicia(sucursal.getFranquicia().getIdFranquicia());

        return responseSucursal;
    }

    @Override
    public Sucursal sucursalRequestMapper(RequestSucursal requestSucursal, Franquicia franquicia){
        Sucursal sucursal = new Sucursal();
        sucursal.setNombre(requestSucursal.getNombre());
        sucursal.setFranquicia(franquicia);

        return sucursal;
    }

}
