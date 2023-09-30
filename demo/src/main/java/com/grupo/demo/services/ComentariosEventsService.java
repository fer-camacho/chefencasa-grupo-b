package com.grupo.demo.services;

import com.grupo.demo.entities.Comentarios;
import com.grupo.demo.events.ComentariosCreatedEvent;
import com.grupo.demo.events.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class ComentariosEventsService {

    @Autowired
    private KafkaTemplate<String, Event<?>> comentariosProducer;

    @Value("${topic.customer.name:Comentarios}")
    private String topic;

    public void publish(Comentarios comentarios){
        ComentariosCreatedEvent created = new ComentariosCreatedEvent();
        created.setData(comentarios);
        created.setId(UUID.randomUUID().toString());
        created.setDate(new Date());
        comentariosProducer.send(topic, created);
    }
}
