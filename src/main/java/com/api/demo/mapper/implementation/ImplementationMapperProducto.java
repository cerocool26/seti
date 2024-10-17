package com.api.demo.mapper.implementation;

import com.api.demo.mapper.MapperProducto;
import com.api.demo.model.Producto;
import com.api.demo.model.Sucursal;
import com.api.demo.request.RequestProducto;
import com.api.demo.response.ResponseProducto;
import org.springframework.stereotype.Component;

@Component
public class ImplementationMapperProducto implements MapperProducto {

    @Override
    public Producto productoRequestMapper(RequestProducto requestProducto, Sucursal sucursal) {
        Producto producto = new Producto();
        producto.setNombre(requestProducto.getNombre());
        producto.setStock(requestProducto.getStock());
        producto.setSucursal(sucursal);

        return producto;
    }

    @Override
    public ResponseProducto productoResponseMapper(Producto producto) {
        ResponseProducto responseProducto = new ResponseProducto();
        responseProducto.setIdProducto(producto.getIdProducto());
        responseProducto.setNombre(producto.getNombre());
        responseProducto.setStock(producto.getStock());
        responseProducto.setIdSucursal(producto.getSucursal().getIdSucursal());

        return responseProducto;
    }
}
