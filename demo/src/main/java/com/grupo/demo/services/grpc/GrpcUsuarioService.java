package com.grupo.demo.services.grpc;

import com.grupo.demo.dtos.ResponseData;
import com.grupo.demo.dtos.UsuarioDTO;
import com.grupo.demo.entities.Usuario;
import com.grupo.demo.services.UsuarioService;
import com.unla.chefencasagrpc.grpc.*;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import  io.grpc.stub.*;

@GrpcService
public class GrpcUsuarioService extends usuarioGrpc.usuarioImplBase{

    @Autowired
    UsuarioService usuarioService;

    @Override
    public void crearUsuario(UsuarioRequest request, StreamObserver<ResponseUsuario> responseObserver) {
        UsuarioDTO usuarioAux = new UsuarioDTO();
        usuarioAux.setNombre(request.getNombre());
        usuarioAux.setEmail(request.getEmail());
        usuarioAux.setUsuario(request.getUsuario());
        usuarioAux.setPassword(request.getPassword());
        HttpStatus state = usuarioService.crearUsuario(usuarioAux).getStatusCode();

        ResponseUsuario responseUser = ResponseUsuario.newBuilder()
                .setMessage(String.valueOf(state))
                .build();
        responseObserver.onNext(responseUser);
        responseObserver.onCompleted();
    }

    public void traerUsuarioPorId(UsuarioPorIdRequest request, StreamObserver<ResponseUsuarioObj> responseObserver) {
        ResponseData<UsuarioDTO> user = usuarioService.traerUsuarioPorId(request.getId());
        //System.out.println(user.getData().getUsuario()+user.getData().getEmail());
        responseObserver.onNext(responseUsuarioObjBuilder(user));
        responseObserver.onCompleted();
    }

    private ResponseUsuarioObj responseUsuarioObjBuilder(ResponseData<UsuarioDTO> userData){

        UsuarioObject userObject = UsuarioObject.newBuilder()
                .setId(userData.getData().getId())
                .setNombre(userData.getData().getNombre())
                .setEmail(userData.getData().getEmail())
                .setUsuario(userData.getData().getUsuario())
                .setPassword(userData.getData().getPassword())
                .build();

        ResponseUsuario mensaje = ResponseUsuario.newBuilder()
                .setMessage("Usuario encontrado")
                .build();

        return ResponseUsuarioObj.newBuilder()
                .setUsuarioObject(userObject)
                .setMensaje(mensaje)
                .build();
    }
}
