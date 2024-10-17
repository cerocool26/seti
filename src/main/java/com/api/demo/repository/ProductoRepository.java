package com.api.demo.repository;

import com.api.demo.model.Producto;
import com.api.demo.response.ResponseProductMaxStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto,Long> {

    @Query(value = """
            SELECT P.nombre AS nombreProducto, S.nombre AS nombreSucursal,MAX(P.stock) AS stock
            FROM FRANQUICIA AS F,SUCURSAL AS S,PRODUCTO AS P
            WHERE F.id_franquicia = S.id_franquicia
            AND S.id_sucursal = p.id_sucursal
            AND F.id_franquicia = :idFranquicia
            GROUP BY P.id_producto, S.id_sucursal
            ORDER BY P.stock DESC
            """,nativeQuery = true)
    List<Object[]> getProductsMaxStock(Long idFranquicia);
}
