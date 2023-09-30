package com.grupo.demo.services;

import com.grupo.demo.entities.PopularidadUsuario;
import com.grupo.demo.events.Event;
import com.grupo.demo.events.PopularidadUsuarioCreatedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    public void publish(PopularidadUsuario popularidadUsuario){
        PopularidadUsuarioCreatedEvent created = new PopularidadUsuarioCreatedEvent();
        created.setData(popularidadUsuario);
        created.setId(UUID.randomUUID().toString());
        created.setDate(new Date());
        popularidadUsuarioProducer.send(topic, created);
    }
}
