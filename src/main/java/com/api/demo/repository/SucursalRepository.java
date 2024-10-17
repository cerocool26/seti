package com.api.demo.repository;

import com.api.demo.model.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SucursalRepository extends JpaRepository<Sucursal,Long> {

}
