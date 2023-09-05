package com.grupo.demo.services.grpc;

import com.grupo.demo.dtos.RecetaDTO;
import com.grupo.demo.dtos.ResponseData;
import com.grupo.demo.entities.Receta;
import com.grupo.demo.repositories.IIngredienteRepository;
import com.grupo.demo.services.RecetaService;
import com.unla.chefencasagrpc.grpc.*;
import net.devh.boot.grpc.server.service.GrpcService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import io.grpc.stub.*;
import org.springframework.http.HttpStatus;
import java.util.*;


@GrpcService
public class GrpcRecetaService extends recetaGrpc.recetaImplBase{

    @Autowired
    RecetaService recetaService;

    @Autowired
    IIngredienteRepository ingredienteRepository;

    ModelMapper modelMapper = new ModelMapper();

    public void crearReceta(RecetaRequest request, StreamObserver<ResponseReceta> responseObserver){
        RecetaDTO recetaAux = new RecetaDTO();
        recetaAux.setTitulo(request.getTitulo());
        recetaAux.setDescripcion(request.getDescripcion());
        recetaAux.setTiempo_preparacion(request.getTiempoPreparacion());
        recetaAux.setCategoria(request.getCategoria());

        List<String> ing = request.getIngredientesList();
        Set<String> ingre = new HashSet<>();
        for(String i: ing){
            ingre.add(i);
        }
        recetaAux.setIngredientes(ingre);

        List<String> pas = request.getPasosList();
        Set<String> paso = new HashSet<>();
        for(String p: pas){
            paso.add(p);
        }
        recetaAux.setPasos(paso);


        List<String> fot = request.getFotosList();
        Set<String> foto = new HashSet<>();
        for(String f: fot){
            foto.add(f);
        }
        recetaAux.setFotos(foto);

        HttpStatus state = recetaService.crearReceta(recetaAux).getStatusCode();
        ResponseReceta responseReceta = ResponseReceta.newBuilder()
                .setMessage(String.valueOf(state))
                .build();
        responseObserver.onNext(responseReceta);
        responseObserver.onCompleted();
    }

    public void actualizarReceta(RecetaActualizarRequest request, StreamObserver<ResponseReceta> responseObserver){
        RecetaDTO recetaAux = new RecetaDTO();
        recetaAux.setId(request.getId());
        recetaAux.setTitulo(request.getTitulo());
        recetaAux.setDescripcion(request.getDescripcion());
        recetaAux.setTiempo_preparacion(request.getTiempoPreparacion());
        recetaAux.setCategoria(request.getCategoria());

        List<String> ing = request.getIngredientesList();
        Set<String> ingre = new HashSet<>();
        for(String i: ing){
            ingre.add(i);
        }
        recetaAux.setIngredientes(ingre);

        List<String> pas = request.getPasosList();
        Set<String> paso = new HashSet<>();
        for(String p: pas){
            paso.add(p);
        }
        recetaAux.setPasos(paso);

        List<String> fot = request.getFotosList();
        Set<String> foto = new HashSet<>();
        for(String f: fot){
            foto.add(f);
        }
        recetaAux.setFotos(foto);

        HttpStatus state = recetaService.crearReceta(recetaAux).getStatusCode();
        ResponseReceta responseReceta = ResponseReceta.newBuilder()
                .setMessage(String.valueOf(state))
                .build();
        responseObserver.onNext(responseReceta);
        responseObserver.onCompleted();
    }

    public void traerRecetaPorId(RecetaPorIdRequest request, StreamObserver<ResponseRecetaObj> responseObserver) {
        ResponseData<RecetaDTO> receta = recetaService.traerRecetaPorId(request.getId());
        responseObserver.onNext(responseRecetaObjBuilder(receta));
        responseObserver.onCompleted();
    }

    public void traerRecetasTodas(Empty request, StreamObserver<ResponseRecetaObjList> responseObserver) {
        ResponseRecetaObjList.Builder response = ResponseRecetaObjList.newBuilder();
        List<Receta> recetas = recetaService.traerRecetasTodas();
        for (Receta r : recetas) {
            RecetaObject  recetaObject = RecetaObjBuilder(r.getId(), r.getTitulo(),
                    r.getDescripcion(), r.getTiempo_preparacion(), r.getCategoria(),
                    r.getIngredientes(), r.getPasos(), r.getFotos());
            response.addRecetaObject(recetaObject);
        }
        ResponseReceta mensaje = ResponseReceta.newBuilder()
                .setMessage("Recetas encontradas")
                .build();

        response.setMensaje(mensaje);
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    public void traerPorFiltro(RecetaFiltro request, StreamObserver<ResponseRecetaObjList> responseObserver) {
        ResponseRecetaObjList.Builder response = ResponseRecetaObjList.newBuilder();

        List<Receta> recetas = recetaService.traerPorFiltro(request.getCategoria(), request.getTitulo(),
                        request.getIngredientes(), Integer.valueOf(request.getTiempoDesde()),
                        Integer.valueOf(request.getTiempoHasta()));
        for (Receta r : recetas) {
            RecetaObject  recetaObject = RecetaObjBuilder(r.getId(), r.getTitulo(),
                    r.getDescripcion(), r.getTiempo_preparacion(), r.getCategoria(),
                    r.getIngredientes(), r.getPasos(), r.getFotos());
            response.addRecetaObject(recetaObject);
        }
        ResponseReceta mensaje = ResponseReceta.newBuilder()
                .setMessage("Recetas encontradas")
                .build();

        response.setMensaje(mensaje);
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    private ResponseRecetaObj responseRecetaObjBuilder(ResponseData<RecetaDTO> recetaData){
        RecetaObject recetaObject =  RecetaObjBuilder(recetaData.getData().getId(), recetaData.getData().getTitulo(),
                recetaData.getData().getDescripcion(), recetaData.getData().getTiempo_preparacion(), recetaData.getData().getCategoria(),
                recetaData.getData().getIngredientes(), recetaData.getData().getPasos(), recetaData.getData().getFotos());
        ResponseReceta mensaje = ResponseReceta.newBuilder()
                .setMessage("Receta encontrada")
                .build();

        return ResponseRecetaObj.newBuilder()
                .setRecetaObject(recetaObject)
                .setMensaje(mensaje)
                .build();
    }
    private RecetaObject RecetaObjBuilder(int id, String titulo, String descripcion, int tiempo_preparacion,
                                          String categoria,Set<String> ingredientes, Set<String> pasos, Set<String> fotos){
        RecetaObject.Builder recetaObject = RecetaObject.newBuilder();

        recetaObject.setId(id);
        recetaObject.setTitulo(titulo);
        recetaObject.setDescripcion(descripcion);
        recetaObject.setTiempoPreparacion(tiempo_preparacion);
        recetaObject.setCategoria(categoria);

        //convierto a lista para poder ordenar los pasos
        List<String> pas = new ArrayList<>();
        for(String p: pasos){
            pas.add(p);
        }
        pas.sort(Comparator.naturalOrder());

        for(String i: ingredientes){
            recetaObject.addIngredientes(i);
        }
        for(String p: pas){
            recetaObject.addPasos(p);
        }
        for(String f: fotos){
            recetaObject.addFotos(f);
        }
        return recetaObject.build();
    }
}