package com.grupo.demo.services;

import com.grupo.demo.entities.PopularidadUsuario;
import org.springframework.stereotype.Service;

@Service
public class PopularidadUsuarioService {



    private PopularidadUsuarioEventsService popularidadUsuarioEventsService;

    public PopularidadUsuarioService(PopularidadUsuarioEventsService popularidadUsuarioEventsService){
        super();
        this.popularidadUsuarioEventsService = popularidadUsuarioEventsService;
    }

    public PopularidadUsuario save(PopularidadUsuario popularidadUsuario) {
        this.popularidadUsuarioEventsService.publish(popularidadUsuario);
        return popularidadUsuario;
    }

}
