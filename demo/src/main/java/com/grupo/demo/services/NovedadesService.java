package com.grupo.demo.services;

import com.grupo.demo.entities.Novedades;
import org.springframework.stereotype.Service;

@Service
public class NovedadesService {

    private NovedadesEventsService novedadesEventsService;

    public NovedadesService(NovedadesEventsService novedadesEventsService){
        super();
        this.novedadesEventsService = novedadesEventsService;
    }

    public Novedades save(Novedades novedades) {
        this.novedadesEventsService.publish(novedades);
        return  novedades;
    }

}
