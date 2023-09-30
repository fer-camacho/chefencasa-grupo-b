package com.grupo.demo.services;

import com.grupo.demo.events.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import com.grupo.demo.entities.Novedades;
import com.grupo.demo.events.NovedadesCreatedEvent;
import java.util.Date;
import java.util.UUID;

@Component
public class NovedadesEventsService {

    @Autowired
    private KafkaTemplate<String, Event<?>> novedadesProducer;

    @Value("${topic.customer.name:Novedades}")
    private String topic;

    public void publish(Novedades novedades){
        NovedadesCreatedEvent created = new NovedadesCreatedEvent();
        created.setData(novedades);
        created.setId(UUID.randomUUID().toString());
        created.setDate(new Date());
        novedadesProducer.send(topic, created);
    }

}
