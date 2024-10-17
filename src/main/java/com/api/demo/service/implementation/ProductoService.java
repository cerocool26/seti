package com.api.demo.service.implementation;

import com.api.demo.mapper.MapperProducto;
import com.api.demo.model.Producto;
import com.api.demo.model.Sucursal;
import com.api.demo.repository.ProductoRepository;
import com.api.demo.repository.SucursalRepository;
import com.api.demo.request.RequestProducto;
import com.api.demo.response.ResponseProductMaxStock;
import com.api.demo.response.ResponseProducto;
import com.api.demo.response.ResponseProductoDelete;
import com.api.demo.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private SucursalRepository sucursalRepository;

    @Autowired
    private MapperProducto mapperProducto;


    public ResponseProducto createProducto(RequestProducto requestProducto) throws Exception {

        Optional<Sucursal> sucursal = sucursalRepository.findById(requestProducto.getIdSucursal());
        if (sucursal.isPresent()) {
            try {
                Producto producto = mapperProducto.productoRequestMapper(requestProducto, sucursal.get());
                return mapperProducto.productoResponseMapper(productoRepository.save(producto));

            } catch (Exception e) {
                throw new Exception("Error al guardar el producto " + e.getMessage());
            }

        } else {
            throw new Exception("No existe la Sucursal");
        }
    }

    public ResponseProductoDelete deleteProducto(Long idProducto) throws Exception {
        ResponseProductoDelete responseProductoDelete = new ResponseProductoDelete();
        Optional<Producto> producto = productoRepository.findById(idProducto);
        if (producto.isPresent()) {
            try {
                productoRepository.delete(producto.get());
                responseProductoDelete.setIdProducto(producto.get().getIdProducto());
                return responseProductoDelete;
            } catch (Exception e) {
                throw new Exception("Error al elimnar el producto" + e.getMessage());
            }

        } else {
            throw new Exception("No existe el producto");
        }
    }

    public ResponseProducto updateProductoStock(RequestProducto requestProducto) throws Exception {
        Optional<Producto> producto = productoRepository.findById(requestProducto.getIdProducto());
        if (producto.isPresent()) {
            try {
                producto.get().setStock(requestProducto.getStock());
                productoRepository.save(producto.get());
                return mapperProducto.productoResponseMapper(producto.get());

            } catch (Exception e) {
                throw new Exception("Error al actualizar el producto " + e.getMessage());
            }

        } else {
            throw new Exception("No existe el producto");
        }

    }

    public List<ResponseProductMaxStock> getProductsMaxStock(Long idFranquicia) throws Exception {
        var listProductos = productoRepository.getProductsMaxStock(idFranquicia);
        if (!listProductos.isEmpty()) {
            try {
                return convertToResponseProductMaxStock(listProductos);
            } catch (Exception e) {
                throw new Exception("Error listado productos max stock" + e.getMessage());
            }
        } else {
            throw new Exception("No hay productos para esa franquicia");
        }
    }

    /** Metodo funcional */
    public static List<ResponseProductMaxStock> convertToResponseProductMaxStock(List<Object[]> listProductos) {
        return listProductos.stream()
                .map(product -> new ResponseProductMaxStock(
                        (String) product[0],
                        (String) product[1],
                        (Integer) product[2]
                ))
                .collect(Collectors.toList());
    }

    public ResponseProducto updateNombreProducto(RequestProducto requestProducto)throws Exception{
        Optional<Producto> producto = productoRepository.findById(requestProducto.getIdProducto());
        if (producto.isPresent()) {
            try {
                producto.get().setNombre(requestProducto.getNombre());
                productoRepository.save(producto.get());
                return mapperProducto.productoResponseMapper(producto.get());

            } catch (Exception e) {
                throw new Exception("Error al actualizar el producto " + e.getMessage());
            }

        } else {
            throw new Exception("No existe el producto");
        }

    }
}
