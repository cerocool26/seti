package com.api.demo.mapper;

import com.api.demo.model.Franquicia;
import com.api.demo.request.RequestFranquicia;
import com.api.demo.response.ResponseFranquicia;

public interface MapperFranquicia {

    ResponseFranquicia franquiciaResponseMapper(Franquicia franquicia);

    Franquicia franquiciaRequestMapper(RequestFranquicia requestFranquicia);
}
