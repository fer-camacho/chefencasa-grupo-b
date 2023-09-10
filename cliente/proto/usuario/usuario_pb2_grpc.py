# Generated by the gRPC Python protocol compiler plugin. DO NOT EDIT!
"""Client and server classes corresponding to protobuf-defined services."""
import grpc

import proto.usuario.usuario_pb2 as usuario__pb2


class usuarioStub(object):
    """Missing associated documentation comment in .proto file."""

    def __init__(self, channel):
        """Constructor.

        Args:
            channel: A grpc.Channel.
        """
        self.crearUsuario = channel.unary_unary(
                '/usuario/crearUsuario',
                request_serializer=usuario__pb2.UsuarioRequest.SerializeToString,
                response_deserializer=usuario__pb2.ResponseUsuario.FromString,
                )
        self.traerUsuarioPorId = channel.unary_unary(
                '/usuario/traerUsuarioPorId',
                request_serializer=usuario__pb2.UsuarioPorIdRequest.SerializeToString,
                response_deserializer=usuario__pb2.ResponseUsuarioObj.FromString,
                )
        self.traerRecetasFavoritas = channel.unary_unary(
                '/usuario/traerRecetasFavoritas',
                request_serializer=usuario__pb2.UsuarioPorIdRequest.SerializeToString,
                response_deserializer=usuario__pb2.ResponseUsuarioObjList.FromString,
                )
        self.marcarRecetaFavorita = channel.unary_unary(
                '/usuario/marcarRecetaFavorita',
                request_serializer=usuario__pb2.UsuarioMarcarFavoritaRequest.SerializeToString,
                response_deserializer=usuario__pb2.ResponseUsuario.FromString,
                )
        self.seguirUsuario = channel.unary_unary(
                '/usuario/seguirUsuario',
                request_serializer=usuario__pb2.SeguirUsuarioRequest.SerializeToString,
                response_deserializer=usuario__pb2.ResponseUsuario.FromString,
                )
        self.traerUsuariosSeguidos = channel.unary_unary(
                '/usuario/traerUsuariosSeguidos',
                request_serializer=usuario__pb2.UsuarioPorIdRequest.SerializeToString,
                response_deserializer=usuario__pb2.ResponseSeguidosObjList.FromString,
                )


class usuarioServicer(object):
    """Missing associated documentation comment in .proto file."""

    def crearUsuario(self, request, context):
        """Missing associated documentation comment in .proto file."""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')

    def traerUsuarioPorId(self, request, context):
        """Missing associated documentation comment in .proto file."""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')

    def traerRecetasFavoritas(self, request, context):
        """Missing associated documentation comment in .proto file."""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')

    def marcarRecetaFavorita(self, request, context):
        """Missing associated documentation comment in .proto file."""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')

    def seguirUsuario(self, request, context):
        """Missing associated documentation comment in .proto file."""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')

    def traerUsuariosSeguidos(self, request, context):
        """Missing associated documentation comment in .proto file."""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')


def add_usuarioServicer_to_server(servicer, server):
    rpc_method_handlers = {
            'crearUsuario': grpc.unary_unary_rpc_method_handler(
                    servicer.crearUsuario,
                    request_deserializer=usuario__pb2.UsuarioRequest.FromString,
                    response_serializer=usuario__pb2.ResponseUsuario.SerializeToString,
            ),
            'traerUsuarioPorId': grpc.unary_unary_rpc_method_handler(
                    servicer.traerUsuarioPorId,
                    request_deserializer=usuario__pb2.UsuarioPorIdRequest.FromString,
                    response_serializer=usuario__pb2.ResponseUsuarioObj.SerializeToString,
            ),
            'traerRecetasFavoritas': grpc.unary_unary_rpc_method_handler(
                    servicer.traerRecetasFavoritas,
                    request_deserializer=usuario__pb2.UsuarioPorIdRequest.FromString,
                    response_serializer=usuario__pb2.ResponseUsuarioObjList.SerializeToString,
            ),
            'marcarRecetaFavorita': grpc.unary_unary_rpc_method_handler(
                    servicer.marcarRecetaFavorita,
                    request_deserializer=usuario__pb2.UsuarioMarcarFavoritaRequest.FromString,
                    response_serializer=usuario__pb2.ResponseUsuario.SerializeToString,
            ),
            'seguirUsuario': grpc.unary_unary_rpc_method_handler(
                    servicer.seguirUsuario,
                    request_deserializer=usuario__pb2.SeguirUsuarioRequest.FromString,
                    response_serializer=usuario__pb2.ResponseUsuario.SerializeToString,
            ),
            'traerUsuariosSeguidos': grpc.unary_unary_rpc_method_handler(
                    servicer.traerUsuariosSeguidos,
                    request_deserializer=usuario__pb2.UsuarioPorIdRequest.FromString,
                    response_serializer=usuario__pb2.ResponseSeguidosObjList.SerializeToString,
            ),
    }
    generic_handler = grpc.method_handlers_generic_handler(
            'usuario', rpc_method_handlers)
    server.add_generic_rpc_handlers((generic_handler,))


 # This class is part of an EXPERIMENTAL API.
class usuario(object):
    """Missing associated documentation comment in .proto file."""

    @staticmethod
    def crearUsuario(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/usuario/crearUsuario',
            usuario__pb2.UsuarioRequest.SerializeToString,
            usuario__pb2.ResponseUsuario.FromString,
            options, channel_credentials,
            insecure, call_credentials, compression, wait_for_ready, timeout, metadata)

    @staticmethod
    def traerUsuarioPorId(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/usuario/traerUsuarioPorId',
            usuario__pb2.UsuarioPorIdRequest.SerializeToString,
            usuario__pb2.ResponseUsuarioObj.FromString,
            options, channel_credentials,
            insecure, call_credentials, compression, wait_for_ready, timeout, metadata)

    @staticmethod
    def traerRecetasFavoritas(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/usuario/traerRecetasFavoritas',
            usuario__pb2.UsuarioPorIdRequest.SerializeToString,
            usuario__pb2.ResponseUsuarioObjList.FromString,
            options, channel_credentials,
            insecure, call_credentials, compression, wait_for_ready, timeout, metadata)

    @staticmethod
    def marcarRecetaFavorita(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/usuario/marcarRecetaFavorita',
            usuario__pb2.UsuarioMarcarFavoritaRequest.SerializeToString,
            usuario__pb2.ResponseUsuario.FromString,
            options, channel_credentials,
            insecure, call_credentials, compression, wait_for_ready, timeout, metadata)

    @staticmethod
    def seguirUsuario(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/usuario/seguirUsuario',
            usuario__pb2.SeguirUsuarioRequest.SerializeToString,
            usuario__pb2.ResponseUsuario.FromString,
            options, channel_credentials,
            insecure, call_credentials, compression, wait_for_ready, timeout, metadata)

    @staticmethod
    def traerUsuariosSeguidos(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/usuario/traerUsuariosSeguidos',
            usuario__pb2.UsuarioPorIdRequest.SerializeToString,
            usuario__pb2.ResponseSeguidosObjList.FromString,
            options, channel_credentials,
            insecure, call_credentials, compression, wait_for_ready, timeout, metadata)
