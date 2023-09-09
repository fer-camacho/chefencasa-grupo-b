from importlib.abc import Finder
import grpc
import proto.receta.receta_pb2 as service_pb2
import proto.receta.receta_pb2_grpc as service_grpc

class RecetaCliente(object):

    def __init__(self):
        self.host = 'localhost'
        self.server_port = 9090

        #Canal de comunicación con el servidor
        self.channel = grpc.insecure_channel('{}:{}'.format(self.host,self.server_port))
        self.stub = service_grpc.recetaStub(self.channel)


    def crearReceta(self, receta):
        recetaCreada = service_pb2.RecetaRequest(

        titulo = receta['titulo'],
        descripcion = receta['descripcion'],
        tiempo_preparacion = receta['tiempo_preparacion'],
        categoria = receta['categoria'],
        ingredientes = receta['ingredientes'],
        pasos = receta['pasos'],
        fotos = receta['fotos'],
        usuario_actual = receta['usuario_actual']
        )
        return self.stub.crearReceta(recetaCreada)
    

    def actualizarReceta(self, receta):
        recetaEditada = service_pb2.RecetaActualizarRequest(
        id = receta['id'],
        titulo = receta['titulo'],
        descripcion = receta['descripcion'],
        tiempo_preparacion = receta['tiempo_preparacion'],
        categoria = receta['categoria'],
        ingredientes = receta['ingredientes'],
        pasos = receta['pasos'],
        fotos = receta['fotos'],
        usuario_actual = receta['usuario_actual']
        )
        return self.stub.actualizarReceta(recetaEditada)

    def traerRecetaPorId(self, receta):
        receta = service_pb2.RecetaPorIdRequest(
        id = receta['id']
        )
        return self.stub.traerRecetaPorId(receta)
    
    def traerRecetasTodas(self, receta):
        receta = service_pb2.Empty(
        )
        return self.stub.traerRecetasTodas(receta)
    
    def traerPorFiltro(self, receta):
        receta = service_pb2.RecetaFiltro(
        categoria = receta['categoria'],
        titulo = receta['titulo'],
        ingredientes = receta['ingredientes'],
        tiempo_desde = receta['tiempo_desde'],
        tiempo_hasta = receta['tiempo_hasta'],
        autorId = receta['autorId'],
        favoritoUsuarioId = receta['favoritoUsuarioId']
        )
        return self.stub.traerPorFiltro(receta)
RecetaCliente()