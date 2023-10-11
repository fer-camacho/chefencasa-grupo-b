package com.grupo.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.kafka.event.ListenerContainerIdleEvent;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduleConsumerService implements ApplicationListener<ListenerContainerIdleEvent>{

    @Autowired
    private KafkaListenerEndpointRegistry endpointRegistry;

    public ScheduleConsumerService(KafkaListenerEndpointRegistry endpointRegistry) {
        this.endpointRegistry = endpointRegistry;
    }

    @Override
    public void onApplicationEvent(ListenerContainerIdleEvent event) {
        String str = event.getTopicPartitions().toString();
        try {
            if (event.getListenerId().contains("PopularidadReceta")) {
                endpointRegistry.getListenerContainer("PopularidadRecetaListener").stop();
                System.out.println("----------------------------------------Se pausaron los listeners de eventos<PopularidadReceta>----------------------------------------");
            }
            if (event.getListenerId().contains("Comentarios")) {
                endpointRegistry.getListenerContainer("ComentariosListener").stop();
                System.out.println("----------------------------------------Se pausaron los listeners de eventos<Comentarios>----------------------------------------");
            }
            if (event.getListenerId().contains("PopularidadUsuario")) {
                endpointRegistry.getListenerContainer("PopularidadUsuarioListener").stop();
                System.out.println("----------------------------------------Se pausaron los listeners de eventos<PopularidadUsuario>----------------------------------------");
            }
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());

        }
    }

    @Scheduled(fixedRate = 60000)//se reactivan los listeners despues de un periodo configurable
    public void resumeEventListeners() {

        endpointRegistry.getListenerContainer("ComentariosListener").start();
        endpointRegistry.getListenerContainer("PopularidadRecetaListener").start();
        endpointRegistry.getListenerContainer("PopularidadUsuarioListener").start();
        System.out.println("----------------------------------------Se reanudaron los listeners de eventos----------------------------------------");
    }



}
