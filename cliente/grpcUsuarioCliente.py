from importlib.abc import Finder
import grpc
import proto.usuario.usuario_pb2 as service_pb2
import proto.usuario.usuario_pb2_grpc as service_grpc

class UsuarioCliente(object):

    def __init__(self):
        self.host = 'localhost'
        self.server_port = 9090

        #Canal de comunicación con el servidor
        self.channel = grpc.insecure_channel('{}:{}'.format(self.host,self.server_port))
        self.stub = service_grpc.usuarioStub(self.channel)


    def crearUsuario(self, user):
        usuarioCreado = service_pb2.UsuarioRequest(
            nombre = user['nombre'],
            email = user['email'],
            usuario = user['usuario'],
            password = user['password']
        )
        return self.stub.crearUsuario(usuarioCreado)
    
    def traerUsuarioPorId(self, user):
        usuarioEncontrado = service_pb2.UsuarioPorIdRequest(
            id = user['id']
        )
        return self.stub.traerUsuarioPorId(usuarioEncontrado)

UsuarioCliente()