package com.grupo.demo.services;

import com.grupo.demo.dtos.PopularidadUsuarioDTO;
import com.grupo.demo.entities.PopularidadUsuario;
import com.grupo.demo.events.Event;
import com.grupo.demo.events.PopularidadUsuarioCreatedEvent;
import com.grupo.demo.repositories.IPopularidadUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class PopularidadUsuarioEventsService {

    @Autowired
    private KafkaTemplate<String, Event<?>> popularidadUsuarioProducer;

    @Value("${topic.customer.name:PopularidadUsuario}")
    private String topic;

    @Autowired
    IPopularidadUsuarioRepository popularidadUsuarioRepository;

    public void publish(PopularidadUsuarioDTO popularidadUsuarioDTO){
        PopularidadUsuarioCreatedEvent created = new PopularidadUsuarioCreatedEvent();
        created.setData(popularidadUsuarioDTO);
        created.setId(UUID.randomUUID().toString());
        created.setDate(new Date());
        popularidadUsuarioProducer.send(topic, created);
    }

    //Consumer
    @KafkaListener(id = "PopularidadUsuarioListener",
            topics = "PopularidadUsuario",
            containerFactory = "kafkaListenerContainerFactory",
            groupId = "grupo1",
            autoStartup = "false"
    )
    public void consumer(PopularidadUsuarioCreatedEvent event){
        calculateAndPersistPopularityScore(event.getData());
    }

    public void calculateAndPersistPopularityScore (PopularidadUsuarioDTO popUsr) {

        PopularidadUsuario dbPopUsr = popularidadUsuarioRepository.getPopularityByUserName(popUsr.getNombreUsuario());

        if(dbPopUsr != null ){
            dbPopUsr.setPuntaje(dbPopUsr.getPuntaje() + popUsr.getPuntaje());
        }
        else{
            dbPopUsr = new PopularidadUsuario(
                    popUsr.getNombreUsuario(),
                    popUsr.getPuntaje()
            );
        }
        popularidadUsuarioRepository.save(dbPopUsr);
    }
}
