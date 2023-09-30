package com.grupo.demo.services;

import com.grupo.demo.entities.PopularidadReceta;
import com.grupo.demo.events.Event;
import com.grupo.demo.events.PopularidadRecetaCreatedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class PopularidadRecetaEventsService {

    @Autowired
    private KafkaTemplate<String, Event<?>> popularidadRecetaProducer;

    @Value("${topic.customer.name:PopularidadReceta}")
    private String topic;

    public void publish(PopularidadReceta popularidadReceta){
        PopularidadRecetaCreatedEvent created = new PopularidadRecetaCreatedEvent();
        created.setData(popularidadReceta);
        created.setId(UUID.randomUUID().toString());
        created.setDate(new Date());
        popularidadRecetaProducer.send(topic, created);
    }
}
