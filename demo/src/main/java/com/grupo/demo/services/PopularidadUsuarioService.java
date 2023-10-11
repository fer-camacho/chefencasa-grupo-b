package com.grupo.demo.services;

import com.grupo.demo.dtos.PopularidadUsuarioDTO;
import org.springframework.stereotype.Service;

@Service
public class PopularidadUsuarioService {



    private PopularidadUsuarioEventsService popularidadUsuarioEventsService;

    public PopularidadUsuarioService(PopularidadUsuarioEventsService popularidadUsuarioEventsService){
        super();
        this.popularidadUsuarioEventsService = popularidadUsuarioEventsService;
    }

    public PopularidadUsuarioDTO save(PopularidadUsuarioDTO popularidadUsuarioDTO) {
        this.popularidadUsuarioEventsService.publish(popularidadUsuarioDTO);
        return popularidadUsuarioDTO;
    }

}
