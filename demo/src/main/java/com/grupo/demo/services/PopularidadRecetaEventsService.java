package com.grupo.demo.services;

import com.grupo.demo.dtos.PopularidadRecetaDTO;
import com.grupo.demo.entities.PopularidadReceta;
import com.grupo.demo.events.Event;
import com.grupo.demo.events.PopularidadRecetaCreatedEvent;
import com.grupo.demo.repositories.IPopularidadRecetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
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

    @Autowired
    private IPopularidadRecetaRepository popularidadRecetaRepository;

    public void publish(PopularidadRecetaDTO popularidadRecetaDTO){
        PopularidadRecetaCreatedEvent created = new PopularidadRecetaCreatedEvent();
        created.setData(popularidadRecetaDTO);
        created.setId(UUID.randomUUID().toString());
        created.setDate(new Date());
        popularidadRecetaProducer.send(topic, created);
    }

    //Consumer
    @KafkaListener(id = "PopularidadRecetaListener",
            topics = "PopularidadReceta",
            containerFactory = "kafkaListenerContainerFactory",
            groupId = "grupo1",
            autoStartup = "false"
    )
    public void consumer(PopularidadRecetaCreatedEvent event){
        calculateAndPersistPopularityScore(event.getData());
    }

    public void calculateAndPersistPopularityScore (PopularidadRecetaDTO popRec) {
        PopularidadReceta dbPopRec = popularidadRecetaRepository.getPopularityByRecipeId(popRec.getId_receta());
        if(dbPopRec != null ){
            dbPopRec.setPuntaje(dbPopRec.getPuntaje() + popRec.getPuntaje());
        }
        else{
            dbPopRec = new PopularidadReceta(
                    popRec.getId_receta(),
                    popRec.getPuntaje()
            );
        }
        popularidadRecetaRepository.save(dbPopRec);
    }
}
