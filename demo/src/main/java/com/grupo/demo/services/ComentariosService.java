package com.grupo.demo.services;

import com.grupo.demo.dtos.ComentariosDTO;
import org.springframework.stereotype.Service;

@Service
public class ComentariosService {

    private ComentariosEventsService comentariosEventsService;

    public ComentariosService(ComentariosEventsService comentariosEventsService){
        super();
        this.comentariosEventsService = comentariosEventsService;
    }

    public ComentariosDTO save(ComentariosDTO comentariosDTO) {
        this.comentariosEventsService.publish(comentariosDTO);
        return comentariosDTO;
    }
}
