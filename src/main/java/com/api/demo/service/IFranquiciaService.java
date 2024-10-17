package com.api.demo.service;

import com.api.demo.request.RequestFranquicia;
import com.api.demo.response.ResponseFranquicia;

public interface IFranquiciaService {

    ResponseFranquicia createFranquicia(RequestFranquicia requestFranquicia) ;
    ResponseFranquicia updateNombreFranquicia(RequestFranquicia requestFranquicia) throws Exception;
}
