package com.api.demo.mapper;

import com.api.demo.model.Franquicia;
import com.api.demo.model.Sucursal;
import com.api.demo.request.RequestSucursal;
import com.api.demo.response.ResponseSucursal;

import java.util.Optional;

public interface MapperSucursal {

    ResponseSucursal sucursalResponsetMapper(Sucursal sucursal);

    Sucursal sucursalRequestMapper(RequestSucursal requestSucursal, Franquicia franquicia);
}
