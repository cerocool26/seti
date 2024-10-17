package com.api.demo.service.implementation;

import com.api.demo.mapper.MapperSucursal;
import com.api.demo.model.Franquicia;
import com.api.demo.model.Sucursal;
import com.api.demo.repository.FranquiciaRepository;
import com.api.demo.repository.SucursalRepository;
import com.api.demo.request.RequestSucursal;
import com.api.demo.response.ResponseSucursal;
import com.api.demo.service.ISucursalSerivice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SucursalService implements ISucursalSerivice {

    @Autowired
    private SucursalRepository sucursalRepository;

    @Autowired
    private FranquiciaRepository franquiciaRepository;

    @Autowired
    private MapperSucursal mapperSucursal;

    public ResponseSucursal createSucursal(RequestSucursal requestSucursal) throws Exception {

        Optional<Franquicia> franquicia = franquiciaRepository.findById(requestSucursal.getIdFranquicia());
        if (franquicia.isPresent()) {
            try {
                Sucursal sucursal = mapperSucursal.sucursalRequestMapper(requestSucursal, franquicia.get());
                return mapperSucursal.sucursalResponsetMapper(sucursalRepository.save(sucursal));
            } catch (Exception e) {
                throw new Exception("Error guardando la sucursal " + e.getMessage());
            }
        } else {
            throw new Exception("No existe la Franquicia");
        }
    }

    public ResponseSucursal updateNombreSucursal(RequestSucursal requestSucursal) throws Exception {
        Optional<Sucursal> sucursal = sucursalRepository.findById(requestSucursal.getIdSucursal());
        if (sucursal.isPresent()) {
            try {
                sucursal.get().setNombre(requestSucursal.getNombre());
                sucursalRepository.save(sucursal.get());
                return mapperSucursal.sucursalResponsetMapper(sucursal.get());

            } catch (Exception e) {
                throw new Exception("Error al actualizar la sucursal " + e.getMessage());
            }

        } else {
            throw new Exception("No existe la sucursal");
        }
    }
}
