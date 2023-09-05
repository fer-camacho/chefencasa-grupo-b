package com.grupo.demo.services;

import com.grupo.demo.constants.RecetaConstants;
import com.grupo.demo.constants.UsuarioConstants;
import com.grupo.demo.converters.RecetaConverter;
import com.grupo.demo.dtos.RecetaDTO;
import com.grupo.demo.dtos.ResponseData;
import com.grupo.demo.entities.Receta;
import com.grupo.demo.repositories.IRecetaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.*;

@Service("recetaService")
public class RecetaService {

    @Autowired
    IRecetaRepository recetaRepository;

    ModelMapper modelMapper = new ModelMapper();

    public ResponseEntity<String> crearReceta(RecetaDTO receta){
        Receta aux = modelMapper.map(receta, Receta.class);
        if (aux.getFotos().size()>5){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("La receta no puede tener mas de 5 fotos");
        }
        recetaRepository.save(aux);
        return ResponseEntity.status(HttpStatus.CREATED).body("La receta fue creada");
    }

    public ResponseData<RecetaDTO> traerRecetaPorId(int id){
        Optional<Receta> recetaResult = recetaRepository.findById(id);
        return recetaResult.map(
                        receta -> new ResponseData<>(RecetaConverter.fromRecetaToRecetaDTO(receta),
                                RecetaConstants.OK))
                .orElseGet(
                        () -> new ResponseData<>(null, RecetaConstants.USER_NOT_FOUND_ERROR_MESSAGE));
    }

    public List<Receta> traerRecetasTodas(){
        List<Receta> recetaResult = recetaRepository.findAll();
        return recetaResult;
    }

    public List<Receta> traerPorFiltro(String categoria, String titulo, String ingred,int tiempo_desde, int tiempo_hasta){
        List<Receta> recetas = new ArrayList<>();
        String consulta = armarQuery(categoria, titulo, ingred, tiempo_desde, tiempo_hasta);

        try {
            String url = "jdbc:mysql://localhost:3306/db_chefencasa";
            String usuario = UsuarioConstants.USER;
            String contraseña = UsuarioConstants.PASSWORD;
            Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
            Statement statement = conexion.createStatement();
            ResultSet resultado = statement.executeQuery(consulta);
            System.out.println(consulta);

            while (resultado.next()) {

                Receta receta = new Receta();
                receta.setId(resultado.getInt("id"));
                receta.setTitulo(resultado.getString("titulo"));
                receta.setDescripcion(resultado.getString("descripcion"));
                receta.setCategoria(resultado.getString("categoria"));
                receta.setTiempo_preparacion(resultado.getInt("tiempo_preparacion"));

                Connection conexionIngredientes = DriverManager.getConnection(url, usuario, contraseña);
                Statement statementIngredientes = conexion.createStatement();
                ResultSet resultadoIngredientes = statementIngredientes.executeQuery("select * from receta_ingredientes where receta_id = "+ receta.getId());
                Set<String> ingredientes = new HashSet<>();
                while (resultadoIngredientes.next()){
                    ingredientes.add(resultadoIngredientes.getString("ingredientes"));
                }
                receta.setIngredientes(ingredientes);
                resultadoIngredientes.close();
                statementIngredientes.close();
                conexionIngredientes.close();

                Connection conexionPasos = DriverManager.getConnection(url, usuario, contraseña);
                Statement statementPasos = conexion.createStatement();
                ResultSet resultadoPasos = statementPasos.executeQuery("select * from receta_pasos where receta_id = "+ receta.getId());
                Set<String> pasos = new HashSet<>();
                while (resultadoPasos.next()){
                    pasos.add(resultadoPasos.getString("pasos"));
                }
                receta.setPasos(pasos);
                resultadoPasos.close();
                statementPasos.close();
                conexionPasos.close();

                Connection conexionFotos = DriverManager.getConnection(url, usuario, contraseña);
                Statement statementFotos = conexion.createStatement();
                ResultSet resultadoFotos = statementFotos.executeQuery("select * from receta_fotos where receta_id = "+ receta.getId());
                Set<String> fotos = new HashSet<>();
                while (resultadoFotos.next()){
                    fotos.add(resultadoFotos.getString("fotos"));
                }
                receta.setFotos(fotos);
                resultadoFotos.close();
                statementFotos.close();
                conexionFotos.close();
                recetas.add(receta);
            }

            // Cerrar la conexión y los recursos
            resultado.close();
            statement.close();
            conexion.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return recetas;
    }

    public String armarQuery(String categoria, String titulo, String ingredientes, int tiempo_desde, int tiempo_hasta) {
        String consulta = "select * from receta";
        if (!categoria.isEmpty() || !titulo.isEmpty() || (tiempo_desde != 0 && tiempo_hasta!=0)){
            consulta+= " where";
            if (!categoria.isEmpty()) {
                consulta +=" categoria = '" + categoria + "'";
            }
            if (!titulo.isEmpty()) {
                if(!categoria.isEmpty()){
                    consulta += " and";
                }
                consulta +=" titulo like '%" + titulo + "%'";
            }
            if (tiempo_desde != 0 && tiempo_hasta!=0) {
                if (!titulo.isEmpty()){
                    consulta += " and";
                }
                consulta +=" tiempo_preparacion between "+ tiempo_desde + " and " + tiempo_hasta;
            }
            if (!ingredientes.isEmpty()) {
                if(tiempo_desde != 0 && tiempo_hasta!=0){
                    consulta += " and";
                }
                consulta += " id in (select receta_id from receta_ingredientes where ingredientes = '" + ingredientes + "')";
            }
        }
        return consulta;
    }
}
