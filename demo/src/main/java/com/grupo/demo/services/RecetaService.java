package com.grupo.demo.services;

import com.grupo.demo.constants.RecetaConstants;
import com.grupo.demo.constants.UsuarioConstants;
import com.grupo.demo.converters.RecetaConverter;
import com.grupo.demo.dtos.*;
import com.grupo.demo.entities.*;
import com.grupo.demo.repositories.IRecetaRepository;
import com.grupo.demo.repositories.IUsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.*;

@Service("recetaService")
public class RecetaService {

    @Autowired
    IRecetaRepository recetaRepository;

    @Autowired
    IUsuarioRepository usuarioRepository;

    @Autowired
    NovedadesService novedadesService;

    @Autowired
    ComentariosService comentariosService;

    @Autowired
    PopularidadRecetaService popularidadRecetaService;

    @Autowired
    @Lazy
    UsuarioService usuarioService;

    ModelMapper modelMapper = new ModelMapper();

    public ResponseEntity<String> crearReceta(RecetaDTO receta){
        Receta aux = modelMapper.map(receta, Receta.class);
        if (aux.getFotos().size()>5){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("La receta no puede tener mas de 5 fotos");
        }
        recetaRepository.save(aux);

        Optional<Usuario> userResult =  usuarioRepository.findById(receta.getAutorId());
        Novedades nov = new Novedades(userResult.get().getUsuario(), receta.getTitulo(), receta.getFotos().iterator().next());
        novedadesService.save(nov);
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

    public List<Receta> traerPorFiltro(String categoria, String titulo, String ingred,int tiempo_desde, int tiempo_hasta, int autorId, int favoritoUsuarioId){
        List<Receta> recetas = new ArrayList<>();
        String consulta = armarQuery(categoria, titulo, ingred, tiempo_desde, tiempo_hasta, autorId, favoritoUsuarioId);

        try {
            String url = "jdbc:mysql://localhost:3306/db_chefencasa";
            Connection conexion = DriverManager.getConnection(url, UsuarioConstants.USER, UsuarioConstants.PASSWORD);
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
                receta.setAutorId(resultado.getInt("autor_id"));
                AtributeHelper(conexion, url, UsuarioConstants.USER, UsuarioConstants.PASSWORD, "select * from receta_ingredientes where receta_id = ", "ingredientes", receta);
                AtributeHelper(conexion, url, UsuarioConstants.USER, UsuarioConstants.PASSWORD, "select * from receta_pasos where receta_id = ", "pasos", receta);
                AtributeHelper(conexion, url, UsuarioConstants.USER, UsuarioConstants.PASSWORD, "select * from receta_fotos where receta_id = ", "fotos", receta);

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

    public Receta AtributeHelper(Connection conexion, String url, String usuario, String contraseña, String sql, String etiqueta, Receta receta){
        try {
            Connection conexionPasos = DriverManager.getConnection(url, usuario, contraseña);
            Statement statementPasos = conexion.createStatement();
            ResultSet resultadosQuery = statementPasos.executeQuery(sql + receta.getId());
            Set<String> resultados = new HashSet<>();
            while (resultadosQuery.next()) {
                resultados.add(resultadosQuery.getString(etiqueta));
            }
            if (etiqueta.equals("pasos")){
                receta.setPasos(resultados);
            } else if (etiqueta.equals("ingredientes")){
                receta.setIngredientes(resultados);
            } else {
                receta.setFotos(resultados);
            }
            resultadosQuery.close();
            statementPasos.close();
            conexionPasos.close();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return receta;
    }

    public String armarQuery(String categoria, String titulo, String ingredientes, int tiempo_desde, int tiempo_hasta, int autorId, int favoritoUsuarioId) {
        String consulta = "SELECT * FROM receta WHERE 1=1";
        if (!categoria.isEmpty()) {
            consulta +=" AND categoria = '" + categoria + "'";
        }
        if (!titulo.isEmpty()) {
            consulta +=" AND titulo LIKE '%" + titulo + "%'";
        }
        if (tiempo_desde != 0 && tiempo_hasta!=0) {
            consulta +=" AND tiempo_preparacion BETWEEN "+ tiempo_desde + " AND " + tiempo_hasta;
        }
        if (!ingredientes.isEmpty()) {
            consulta += " AND id IN (SELECT receta_id FROM receta_ingredientes WHERE ingredientes = '" + ingredientes + "')";
        }
        if (favoritoUsuarioId != 0) {
            consulta += " AND id IN (SELECT recetas_favoritas FROM usuario_recetas_favoritas WHERE usuario_id = '" + favoritoUsuarioId + "')";
        }
        if (autorId != 0) {
            consulta += " AND autor_id = '" + autorId + "'";
        }

        System.out.println(consulta);
        return consulta;
    }

    public String traerNombreUsuarioAutor(int id_receta) {
        Optional<Receta> receta = recetaRepository.findById(id_receta);
        Optional<Usuario> usuario = usuarioRepository.findById(receta.get().getAutorId());
        return usuario.get().getUsuario();
    }



    public ResponseEntity<String> comentarReceta(int id_usuario, int id_receta, String comentario){
        ResponseData<UsuarioDTO> usuario = usuarioService.traerUsuarioPorId(id_usuario);
        ResponseData<RecetaDTO> receta = traerRecetaPorId(id_receta);
        if (!receta.isEmptyData() && !usuario.isEmptyData()) {
            ComentariosDTO com = new ComentariosDTO(usuario.getData().getUsuario(), receta.getData().getTitulo(), comentario);
            comentariosService.save(com);
            if (id_usuario != receta.getData().getAutorId()){
                PopularidadRecetaDTO rec = new PopularidadRecetaDTO(id_receta, 1);
                popularidadRecetaService.save(rec);
            }
            return ResponseEntity.status(HttpStatus.CREATED).body("El comentario fue guardado.");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("Error al guardar el comentario.");
    }

    public ResponseEntity<String> calificarReceta(int id_usuario, int id_receta, int calificacion){
        ResponseData<RecetaDTO> receta = traerRecetaPorId(id_receta);
        if (id_usuario == receta.getData().getAutorId()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El usuario no puede calificar su propia receta.");
        }
        PopularidadRecetaDTO rec = new PopularidadRecetaDTO(id_receta, calificacion);
        popularidadRecetaService.save(rec);
        return ResponseEntity.status(HttpStatus.CREATED).body("Su calificacion fue guardada.");
    }
}
