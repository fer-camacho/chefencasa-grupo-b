package com.grupo.demo.services;

import com.grupo.demo.entities.PopularidadReceta;
import com.grupo.demo.entities.PopularidadUsuario;
import org.springframework.stereotype.Service;

@Service
public class PopularidadRecetaService {

    private PopularidadRecetaEventsService popularidadRecetaEventsService;

    public PopularidadRecetaService(PopularidadRecetaEventsService popularidadRecetaEventsService) {
        super();
        this.popularidadRecetaEventsService = popularidadRecetaEventsService;
    }

    public PopularidadReceta save(PopularidadReceta popularidadReceta) {
        this.popularidadRecetaEventsService.publish(popularidadReceta);
        return popularidadReceta;
    }
}
