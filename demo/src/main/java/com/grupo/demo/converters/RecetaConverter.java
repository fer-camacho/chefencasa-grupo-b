package com.grupo.demo.converters;

import com.grupo.demo.dtos.RecetaDTO;
import com.grupo.demo.entities.Receta;

public class RecetaConverter {

    public RecetaConverter() {
    }

   public static RecetaDTO fromRecetaToRecetaDTO(Receta receta){
        RecetaDTO dto = new RecetaDTO();
        dto.setId(receta.getId());
        dto.setTitulo(receta.getTitulo());
        dto.setDescripcion(receta.getDescripcion());
        dto.setTiempo_preparacion(receta.getTiempo_preparacion());
        dto.setAutorId(receta.getAutorId());
        dto.setCategoria(receta.getCategoria());
        dto.setIngredientes(receta.getIngredientes());
        dto.setPasos(receta.getPasos());
        dto.setFotos(receta.getFotos());
        return dto;
   }
}
