package com.api.demo.service;

import com.api.demo.request.RequestSucursal;
import com.api.demo.response.ResponseSucursal;

public interface ISucursalSerivice {

    ResponseSucursal createSucursal(RequestSucursal requestSucursal) throws Exception;

    ResponseSucursal updateNombreSucursal(RequestSucursal requestSucursal) throws Exception;
}
