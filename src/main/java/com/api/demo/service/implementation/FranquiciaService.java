package com.api.demo.service.implementation;

import com.api.demo.mapper.MapperFranquicia;
import com.api.demo.model.Franquicia;
import com.api.demo.repository.FranquiciaRepository;
import com.api.demo.request.RequestFranquicia;
import com.api.demo.response.ResponseFranquicia;
import com.api.demo.service.IFranquiciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FranquiciaService implements IFranquiciaService {

    @Autowired
    private FranquiciaRepository franquiciaRepository;

    @Autowired
    private MapperFranquicia mapperFranquicia;

    public ResponseFranquicia createFranquicia(RequestFranquicia requestFranquicia) {
        return mapperFranquicia.franquiciaResponseMapper(franquiciaRepository.save(mapperFranquicia.franquiciaRequestMapper(requestFranquicia)));
    }

    public ResponseFranquicia updateNombreFranquicia(RequestFranquicia requestFranquicia) throws Exception {
        Optional<Franquicia> franquicia = franquiciaRepository.findById(requestFranquicia.getIdFranquicia());
        if (franquicia.isPresent()) {
            try {
                franquicia.get().setNombre(requestFranquicia.getNombre());
                franquiciaRepository.save(franquicia.get());
                return mapperFranquicia.franquiciaResponseMapper(franquicia.get());

            } catch (Exception e) {
                throw new Exception("Error al actualizar la franquicia " + e.getMessage());
            }
        } else {
            throw new Exception("No existe la franquicia");
        }
    }

}
