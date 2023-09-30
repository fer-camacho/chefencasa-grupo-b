package com.grupo.demo.events;

import com.grupo.demo.entities.Comentarios;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ComentariosCreatedEvent extends Event<Comentarios>{
}
