package com.grupo.demo.services.grpc;

import com.grupo.demo.dtos.UsuarioDTO;
import com.grupo.demo.services.UsuarioService;
import com.unla.chefencasagrpc.grpc.ResponseUsuario;
import com.unla.chefencasagrpc.grpc.UsuarioRequest;
import com.unla.chefencasagrpc.grpc.usuarioGrpc;
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
}
