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
        cat = receta['categoria']
        tit = receta['titulo']
        ing = receta['ingredientes']
        desde = receta['tiempo_desde']
        hasta = receta['tiempo_hasta']
        autor = receta['autorId']
        favorito = receta['favoritoUsuarioId']
        
        if (len(cat) == 0): cat = ''
        if (len(tit) == 0): tit = ''
        if (len(ing) == 0): ing = ''
        if (desde == 0): desde = 0
        if (hasta == 0): hasta = 0
        if (autor == 0): autor = 0
        if (favorito == 0): favorito = 0

        receta = service_pb2.RecetaFiltro(
        categoria = cat,
        titulo = tit,
        ingredientes = ing,
        tiempo_desde = desde,
        tiempo_hasta = hasta,
        autorId = autor,
        favoritoUsuarioId = favorito
        )
        return self.stub.traerPorFiltro(receta)
RecetaCliente()