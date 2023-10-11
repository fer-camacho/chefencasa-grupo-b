package com.grupo.demo.events;

import com.grupo.demo.dtos.PopularidadRecetaDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PopularidadRecetaCreatedEvent extends Event<PopularidadRecetaDTO> {
}
