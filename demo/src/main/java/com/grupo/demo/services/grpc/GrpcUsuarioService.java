package com.grupo.demo.services.grpc;

import com.grupo.demo.dtos.RecetaDTO;
import com.grupo.demo.dtos.ResponseData;
import com.grupo.demo.dtos.UsuarioDTO;
import com.grupo.demo.entities.Receta;
import com.grupo.demo.entities.Usuario;
import com.grupo.demo.services.UsuarioService;
import com.unla.chefencasagrpc.grpc.*;
import net.devh.boot.grpc.server.service.GrpcService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import  io.grpc.stub.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

@GrpcService
public class GrpcUsuarioService extends usuarioGrpc.usuarioImplBase{

    @Autowired
    UsuarioService usuarioService;

    ModelMapper modelMapper = new ModelMapper();


    @Override
    public void crearUsuario(UsuarioRequest request, StreamObserver<ResponseUsuario> responseObserver) {
        UsuarioDTO usuarioAux = new UsuarioDTO();
        usuarioAux.setNombre(request.getNombre());
        usuarioAux.setEmail(request.getEmail());
        usuarioAux.setUsuario(request.getUsuario());
        usuarioAux.setPassword(request.getPassword());
        HttpStatus state = usuarioService.crearUsuario(usuarioAux).getStatusCode();
        ResponseUsuario responseUser = responseUsuarioBuilder(String.valueOf(state));
        responseObserver.onNext(responseUser);
        responseObserver.onCompleted();
    }

    public void marcarRecetaFavorita(UsuarioMarcarFavoritaRequest request, StreamObserver<ResponseUsuario> responseObserver) {
        HttpStatus state = usuarioService.marcarFavorita(request.getIdReceta(), request.getIdUsuario()).getStatusCode();
        ResponseUsuario responseUser = responseUsuarioBuilder(String.valueOf(state));
        responseObserver.onNext(responseUser);
        responseObserver.onCompleted();
    }

    public void seguirUsuario(SeguirUsuarioRequest request, StreamObserver<ResponseUsuario> responseObserver) {
        HttpStatus state = usuarioService.seguirUsuario(request.getIdUsuario(), request.getIdUsuarioSeguido()).getStatusCode();
        ResponseUsuario responseUser = responseUsuarioBuilder(String.valueOf(state));
        responseObserver.onNext(responseUser);
        responseObserver.onCompleted();
    }

    public void traerUsuarioPorId(UsuarioPorIdRequest request, StreamObserver<ResponseUsuarioObj> responseObserver) {
        ResponseData<UsuarioDTO> user = usuarioService.traerUsuarioPorId(request.getId());
        responseObserver.onNext(responseUsuarioObjBuilder(user.getData().getId(), user.getData().getNombre(),
                user.getData().getEmail(), user.getData().getUsuario(), user.getData().getPassword())
        );
        responseObserver.onCompleted();
    }

    public void traerRecetasFavoritas(UsuarioPorIdRequest request, StreamObserver<ResponseUsuarioObjList> responseObserver) {
        ResponseUsuarioObjList.Builder response = ResponseUsuarioObjList.newBuilder();
        List<Receta> recetas = usuarioService.traerRecetasFavoritas(request.getId());
        for (Receta r : recetas) {
            RecetaFavoritaObject  recetaFavoritaObject = recetaFavoritaObjectBuilder(r.getId(), r.getTitulo(), r.getDescripcion(),
                    r.getTiempo_preparacion(), r.getCategoria(), r.getIngredientes(), r.getPasos(),r.getFotos());

            response.addRecetaFavoritaObject(recetaFavoritaObject);
        }
        ResponseUsuario mensaje = responseUsuarioBuilder("Recetas favoritas encontradas");
        response.setMensaje(mensaje);
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    public void traerUsuariosSeguidos(UsuarioPorIdRequest request, StreamObserver<ResponseSeguidosObjList> responseObserver) {
        ResponseSeguidosObjList.Builder response= ResponseSeguidosObjList.newBuilder();
        List<Usuario> usuarios = usuarioService.traerUsuariosSeguidos(request.getId());
        System.out.println(modelMapper.map(usuarios.get(0), UsuarioDTO.class));
        for (Usuario u: usuarios){
            UsuarioObject userObject = usuarioObjectBuilder(u.getId(), u.getNombre(), u.getEmail(), u.getUsuario(), u.getPassword());
            response.addUsuarioSeguidoObject(userObject);
        }
        ResponseUsuario mensaje = responseUsuarioBuilder("Usuarios seguidos encontrados");
        response.setMensaje(mensaje);
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    public ResponseUsuario responseUsuarioBuilder(String mensaje){
        ResponseUsuario responseUser = ResponseUsuario.newBuilder()
                .setMessage(String.valueOf(mensaje))
                .build();
        return responseUser;
    }

    public UsuarioObject usuarioObjectBuilder(int id, String nombre, String email, String usuario, String password){
        UsuarioObject usuarioObject = UsuarioObject.newBuilder()
                .setId(id)
                .setNombre(nombre)
                .setEmail(email)
                .setUsuario(usuario)
                .setPassword(password)
                .build();
        return usuarioObject;
    }

    private ResponseUsuarioObj responseUsuarioObjBuilder(int id, String nombre, String email, String usuario, String password){

        UsuarioObject userObject = usuarioObjectBuilder(id, nombre, email, usuario, password);
        ResponseUsuario mensaje = responseUsuarioBuilder("Usuario encontrado.");

        return ResponseUsuarioObj.newBuilder()
                .setUsuarioObject(userObject)
                .setMensaje(mensaje)
                .build();
    }

    public RecetaFavoritaObject recetaFavoritaObjectBuilder(int id, String titulo, String descripcion, int tiempo_preparacion,
                                                            String categoria, Set<String> ingredientes, Set<String> pasos, Set<String> fotos) {
        RecetaFavoritaObject.Builder recetaFavoritaObject =  RecetaFavoritaObject.newBuilder();

        recetaFavoritaObject.setId(id);
        recetaFavoritaObject.setTitulo(titulo);
        recetaFavoritaObject.setDescripcion(descripcion);
        recetaFavoritaObject.setTiempoPreparacion(tiempo_preparacion);
        recetaFavoritaObject.setCategoria(categoria);

        //convierto a lista para poder ordenar los pasos
        List<String> pas = new ArrayList<>();
        for(String p: pasos){
            pas.add(p);
        }
        pas.sort(Comparator.naturalOrder());

        for(String i: ingredientes){
            recetaFavoritaObject.addIngredientes(i);
        }
        for(String p: pas){
            recetaFavoritaObject.addPasos(p);
        }
        for(String f: fotos){
            recetaFavoritaObject.addFotos(f);
        }
        return recetaFavoritaObject.build();
    }




}
