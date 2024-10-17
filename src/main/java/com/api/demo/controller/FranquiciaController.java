package com.api.demo.controller;

import com.api.demo.request.RequestFranquicia;
import com.api.demo.response.ResponseFranquicia;
import com.api.demo.service.IFranquiciaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
@RequestMapping("/franquicia")
@RequiredArgsConstructor
public class FranquiciaController {

    private final IFranquiciaService iFranquiciaService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseFranquicia createFranquicia(@RequestBody RequestFranquicia requestFranquicia) {
        return iFranquiciaService.createFranquicia(requestFranquicia);
    }

    @PatchMapping("/update-nombre")
    public ResponseFranquicia updateNombreFranquicia(@RequestBody RequestFranquicia requestFranquicia) throws Exception {
        return iFranquiciaService.updateNombreFranquicia(requestFranquicia);
    }

}
