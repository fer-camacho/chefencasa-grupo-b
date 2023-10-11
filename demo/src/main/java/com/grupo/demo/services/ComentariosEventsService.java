package com.grupo.demo.services;

import com.grupo.demo.dtos.ComentariosDTO;
import com.grupo.demo.entities.Comentarios;
import com.grupo.demo.events.ComentariosCreatedEvent;
import com.grupo.demo.events.Event;
import com.grupo.demo.repositories.IComentariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
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

    @Autowired
    private IComentariosRepository comentariosRepository;

    public void publish(ComentariosDTO comentariosDTO){
        ComentariosCreatedEvent created = new ComentariosCreatedEvent();
        created.setData(comentariosDTO);
        created.setId(UUID.randomUUID().toString());
        created.setDate(new Date());
        comentariosProducer.send(topic, created);
    }


    @KafkaListener(id = "ComentariosListener",
            topics = "Comentarios",
            containerFactory = "kafkaListenerContainerFactory",
            groupId = "grupo1",
            autoStartup = "false")

    public void consumer(ComentariosCreatedEvent event){
        persistComment(event.getData());
    }

    public void persistComment (ComentariosDTO comment) {
        Comentarios nuevoComentario = new Comentarios(
                comment.getUsuario(),
                comment.getReceta(),
                comment.getComentario()
        );
        comentariosRepository.save(nuevoComentario);
    }
}
