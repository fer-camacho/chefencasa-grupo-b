package com.grupo.demo.services;

import com.grupo.demo.dtos.PopularidadRecetaDTO;
import org.springframework.stereotype.Service;

@Service
public class PopularidadRecetaService {

    private PopularidadRecetaEventsService popularidadRecetaEventsService;

    public PopularidadRecetaService(PopularidadRecetaEventsService popularidadRecetaEventsService) {
        super();
        this.popularidadRecetaEventsService = popularidadRecetaEventsService;
    }

    public PopularidadRecetaDTO save(PopularidadRecetaDTO popularidadRecetaDTO) {
        this.popularidadRecetaEventsService.publish(popularidadRecetaDTO);
        return popularidadRecetaDTO;
    }
}
