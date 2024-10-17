package com.api.demo.mapper;

import com.api.demo.model.Producto;
import com.api.demo.model.Sucursal;
import com.api.demo.request.RequestProducto;
import com.api.demo.response.ResponseProducto;

public interface MapperProducto {

    Producto productoRequestMapper(RequestProducto requestProducto, Sucursal sucursal);
    ResponseProducto productoResponseMapper(Producto producto);
}
