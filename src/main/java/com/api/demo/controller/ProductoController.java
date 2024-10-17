package com.api.demo.controller;

import com.api.demo.request.RequestProducto;
import com.api.demo.response.ResponseProductMaxStock;
import com.api.demo.response.ResponseProducto;
import com.api.demo.response.ResponseProductoDelete;
import com.api.demo.service.IProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
@RequiredArgsConstructor
public class ProductoController {

    private final IProductoService iProductoService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseProducto createProducto(@RequestBody RequestProducto requestProducto) throws Exception {
        return iProductoService.createProducto(requestProducto);
    }

    @DeleteMapping("/{idProducto}")
    ResponseProductoDelete deleteProducto(@PathVariable Long idProducto) throws Exception {
        return iProductoService.deleteProducto(idProducto);
    }

    @PatchMapping("/update-stock")
    ResponseProducto updateProductoStock(@RequestBody RequestProducto requestProducto)throws Exception{
        return iProductoService.updateProductoStock(requestProducto);
    }

    @GetMapping("/max-stock/{idFranquicia}")
    List<ResponseProductMaxStock>  getProductsMaxStock(@PathVariable Long idFranquicia) throws Exception {
        return iProductoService.getProductsMaxStock(idFranquicia);
    }

    @PatchMapping("/update-nombre")
    ResponseProducto updateNombreProducto(@RequestBody RequestProducto requestProducto)throws Exception{
        return iProductoService.updateNombreProducto(requestProducto);
    }


}
