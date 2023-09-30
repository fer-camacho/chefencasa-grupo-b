package com.grupo.demo.events;

import com.grupo.demo.entities.PopularidadReceta;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PopularidadRecetaCreatedEvent extends Event<PopularidadReceta> {
}
