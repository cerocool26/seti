package com.api.demo.controller;

import com.api.demo.request.RequestSucursal;
import com.api.demo.response.ResponseSucursal;
import com.api.demo.service.ISucursalSerivice;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sucursal")
@RequiredArgsConstructor
public class SucursalController {

    private final ISucursalSerivice iSucursalSerivice;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseSucursal createSucursal(@RequestBody RequestSucursal requestSucursal) throws Exception {
        return iSucursalSerivice.createSucursal(requestSucursal);
    }

    @PatchMapping("/update-nombre")
    public ResponseSucursal updateNombreSucursal(@RequestBody RequestSucursal requestSucursal) throws Exception {
        return iSucursalSerivice.updateNombreSucursal(requestSucursal);
    }
}
