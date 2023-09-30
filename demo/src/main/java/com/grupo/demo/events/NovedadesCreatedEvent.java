package com.grupo.demo.events;

import com.grupo.demo.entities.Novedades;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class NovedadesCreatedEvent extends Event<Novedades> {
}
