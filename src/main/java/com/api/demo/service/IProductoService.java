package com.api.demo.service;

import com.api.demo.request.RequestProducto;
import com.api.demo.response.ResponseProductMaxStock;
import com.api.demo.response.ResponseProducto;
import com.api.demo.response.ResponseProductoDelete;

import java.util.List;

public interface IProductoService {

    ResponseProducto createProducto(RequestProducto requestProducto) throws Exception;
    ResponseProductoDelete deleteProducto(Long idProducto) throws Exception;
    ResponseProducto updateProductoStock(RequestProducto requestProducto) throws Exception;
    List<ResponseProductMaxStock> getProductsMaxStock(Long idFranquicia) throws Exception;
    ResponseProducto updateNombreProducto(RequestProducto requestProducto)throws Exception;
}
