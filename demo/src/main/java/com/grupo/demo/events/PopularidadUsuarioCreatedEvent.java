package com.grupo.demo.events;

import com.grupo.demo.entities.PopularidadUsuario;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PopularidadUsuarioCreatedEvent extends Event<PopularidadUsuario> {
}
