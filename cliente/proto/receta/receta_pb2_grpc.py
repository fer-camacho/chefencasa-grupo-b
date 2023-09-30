# Generated by the gRPC Python protocol compiler plugin. DO NOT EDIT!
"""Client and server classes corresponding to protobuf-defined services."""
import grpc

import proto.receta.receta_pb2 as receta__pb2


class recetaStub(object):
    """Missing associated documentation comment in .proto file."""

    def __init__(self, channel):
        """Constructor.

        Args:
            channel: A grpc.Channel.
        """
        self.crearReceta = channel.unary_unary(
                '/receta/crearReceta',
                request_serializer=receta__pb2.RecetaRequest.SerializeToString,
                response_deserializer=receta__pb2.ResponseReceta.FromString,
                )
        self.actualizarReceta = channel.unary_unary(
                '/receta/actualizarReceta',
                request_serializer=receta__pb2.RecetaActualizarRequest.SerializeToString,
                response_deserializer=receta__pb2.ResponseReceta.FromString,
                )
        self.traerRecetaPorId = channel.unary_unary(
                '/receta/traerRecetaPorId',
                request_serializer=receta__pb2.RecetaPorIdRequest.SerializeToString,
                response_deserializer=receta__pb2.ResponseRecetaObj.FromString,
                )
        self.traerRecetasTodas = channel.unary_unary(
                '/receta/traerRecetasTodas',
                request_serializer=receta__pb2.Empty.SerializeToString,
                response_deserializer=receta__pb2.ResponseRecetaObjList.FromString,
                )
        self.traerPorFiltro = channel.unary_unary(
                '/receta/traerPorFiltro',
                request_serializer=receta__pb2.RecetaFiltro.SerializeToString,
                response_deserializer=receta__pb2.ResponseRecetaObjList.FromString,
                )
        self.comentarReceta = channel.unary_unary(
                '/receta/comentarReceta',
                request_serializer=receta__pb2.ComentarioRequest.SerializeToString,
                response_deserializer=receta__pb2.ResponseReceta.FromString,
                )
        self.calificarReceta = channel.unary_unary(
                '/receta/calificarReceta',
                request_serializer=receta__pb2.CalificarRequest.SerializeToString,
                response_deserializer=receta__pb2.ResponseReceta.FromString,
                )


class recetaServicer(object):
    """Missing associated documentation comment in .proto file."""

    def crearReceta(self, request, context):
        """Missing associated documentation comment in .proto file."""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')

    def actualizarReceta(self, request, context):
        """Missing associated documentation comment in .proto file."""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')

    def traerRecetaPorId(self, request, context):
        """Missing associated documentation comment in .proto file."""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')

    def traerRecetasTodas(self, request, context):
        """Missing associated documentation comment in .proto file."""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')

    def traerPorFiltro(self, request, context):
        """Missing associated documentation comment in .proto file."""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')

    def comentarReceta(self, request, context):
        """Missing associated documentation comment in .proto file."""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')

    def calificarReceta(self, request, context):
        """Missing associated documentation comment in .proto file."""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')


def add_recetaServicer_to_server(servicer, server):
    rpc_method_handlers = {
            'crearReceta': grpc.unary_unary_rpc_method_handler(
                    servicer.crearReceta,
                    request_deserializer=receta__pb2.RecetaRequest.FromString,
                    response_serializer=receta__pb2.ResponseReceta.SerializeToString,
            ),
            'actualizarReceta': grpc.unary_unary_rpc_method_handler(
                    servicer.actualizarReceta,
                    request_deserializer=receta__pb2.RecetaActualizarRequest.FromString,
                    response_serializer=receta__pb2.ResponseReceta.SerializeToString,
            ),
            'traerRecetaPorId': grpc.unary_unary_rpc_method_handler(
                    servicer.traerRecetaPorId,
                    request_deserializer=receta__pb2.RecetaPorIdRequest.FromString,
                    response_serializer=receta__pb2.ResponseRecetaObj.SerializeToString,
            ),
            'traerRecetasTodas': grpc.unary_unary_rpc_method_handler(
                    servicer.traerRecetasTodas,
                    request_deserializer=receta__pb2.Empty.FromString,
                    response_serializer=receta__pb2.ResponseRecetaObjList.SerializeToString,
            ),
            'traerPorFiltro': grpc.unary_unary_rpc_method_handler(
                    servicer.traerPorFiltro,
                    request_deserializer=receta__pb2.RecetaFiltro.FromString,
                    response_serializer=receta__pb2.ResponseRecetaObjList.SerializeToString,
            ),
            'comentarReceta': grpc.unary_unary_rpc_method_handler(
                    servicer.comentarReceta,
                    request_deserializer=receta__pb2.ComentarioRequest.FromString,
                    response_serializer=receta__pb2.ResponseReceta.SerializeToString,
            ),
            'calificarReceta': grpc.unary_unary_rpc_method_handler(
                    servicer.calificarReceta,
                    request_deserializer=receta__pb2.CalificarRequest.FromString,
                    response_serializer=receta__pb2.ResponseReceta.SerializeToString,
            ),
    }
    generic_handler = grpc.method_handlers_generic_handler(
            'receta', rpc_method_handlers)
    server.add_generic_rpc_handlers((generic_handler,))


 # This class is part of an EXPERIMENTAL API.
class receta(object):
    """Missing associated documentation comment in .proto file."""

    @staticmethod
    def crearReceta(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/receta/crearReceta',
            receta__pb2.RecetaRequest.SerializeToString,
            receta__pb2.ResponseReceta.FromString,
            options, channel_credentials,
            insecure, call_credentials, compression, wait_for_ready, timeout, metadata)

    @staticmethod
    def actualizarReceta(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/receta/actualizarReceta',
            receta__pb2.RecetaActualizarRequest.SerializeToString,
            receta__pb2.ResponseReceta.FromString,
            options, channel_credentials,
            insecure, call_credentials, compression, wait_for_ready, timeout, metadata)

    @staticmethod
    def traerRecetaPorId(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/receta/traerRecetaPorId',
            receta__pb2.RecetaPorIdRequest.SerializeToString,
            receta__pb2.ResponseRecetaObj.FromString,
            options, channel_credentials,
            insecure, call_credentials, compression, wait_for_ready, timeout, metadata)

    @staticmethod
    def traerRecetasTodas(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/receta/traerRecetasTodas',
            receta__pb2.Empty.SerializeToString,
            receta__pb2.ResponseRecetaObjList.FromString,
            options, channel_credentials,
            insecure, call_credentials, compression, wait_for_ready, timeout, metadata)

    @staticmethod
    def traerPorFiltro(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/receta/traerPorFiltro',
            receta__pb2.RecetaFiltro.SerializeToString,
            receta__pb2.ResponseRecetaObjList.FromString,
            options, channel_credentials,
            insecure, call_credentials, compression, wait_for_ready, timeout, metadata)

    @staticmethod
    def comentarReceta(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/receta/comentarReceta',
            receta__pb2.ComentarioRequest.SerializeToString,
            receta__pb2.ResponseReceta.FromString,
            options, channel_credentials,
            insecure, call_credentials, compression, wait_for_ready, timeout, metadata)

    @staticmethod
    def calificarReceta(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/receta/calificarReceta',
            receta__pb2.CalificarRequest.SerializeToString,
            receta__pb2.ResponseReceta.FromString,
            options, channel_credentials,
            insecure, call_credentials, compression, wait_for_ready, timeout, metadata)
