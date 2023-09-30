package com.grupo.demo.services;

import com.grupo.demo.entities.Comentarios;
import org.springframework.stereotype.Service;

@Service
public class ComentariosService {

    private ComentariosEventsService comentariosEventsService;

    public ComentariosService(ComentariosEventsService comentariosEventsService){
        super();
        this.comentariosEventsService = comentariosEventsService;
    }

    public Comentarios save(Comentarios comentarios) {
        this.comentariosEventsService.publish(comentarios);
        return  comentarios;
    }
}
