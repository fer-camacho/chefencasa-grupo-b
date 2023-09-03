package com.grupo.demo.services.grpc;

import com.grupo.demo.dtos.CategoriaDTO;
import com.grupo.demo.services.CategoriaService;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import com.unla.chefencasagrpc.grpc.*;
import io.grpc.stub.*;

@GrpcService
public class GrpcCategoriaService extends categoriaGrpc.categoriaImplBase{

    @Autowired
    CategoriaService categoriaService;

    @Override
    public void crearCategoria(CategoriaRequest request,
                               StreamObserver<Response> responseObserver) {
        CategoriaDTO categoriaAux = new CategoriaDTO();
        categoriaAux.setDescripcion(request.getDescripcion());
        HttpStatus state = categoriaService.crearCategoria(categoriaAux).getStatusCode();

        Response responseUser = Response.newBuilder()
                .setMessage(String.valueOf(state))
                .build();

        responseObserver.onNext(responseUser);
        responseObserver.onCompleted();
    }
}
