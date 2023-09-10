# -*- coding: utf-8 -*-
# Generated by the protocol buffer compiler.  DO NOT EDIT!
# source: receta.proto
"""Generated protocol buffer code."""
from google.protobuf import descriptor as _descriptor
from google.protobuf import descriptor_pool as _descriptor_pool
from google.protobuf import symbol_database as _symbol_database
from google.protobuf.internal import builder as _builder
# @@protoc_insertion_point(imports)

_sym_db = _symbol_database.Default()




DESCRIPTOR = _descriptor_pool.Default().AddSerializedFile(b'\n\x0creceta.proto\"\xaf\x01\n\rRecetaRequest\x12\x0e\n\x06titulo\x18\x01 \x01(\t\x12\x13\n\x0b\x64\x65scripcion\x18\x02 \x01(\t\x12\x1a\n\x12tiempo_preparacion\x18\x03 \x01(\x05\x12\x11\n\tcategoria\x18\x04 \x01(\t\x12\x14\n\x0cingredientes\x18\x05 \x03(\t\x12\r\n\x05pasos\x18\x06 \x03(\t\x12\r\n\x05\x66otos\x18\x07 \x03(\t\x12\x16\n\x0eusuario_actual\x18\x08 \x01(\x05\"!\n\x0eResponseReceta\x12\x0f\n\x07message\x18\x01 \x01(\t\"\xc5\x01\n\x17RecetaActualizarRequest\x12\n\n\x02id\x18\x01 \x01(\x05\x12\x0e\n\x06titulo\x18\x02 \x01(\t\x12\x13\n\x0b\x64\x65scripcion\x18\x03 \x01(\t\x12\x1a\n\x12tiempo_preparacion\x18\x04 \x01(\x05\x12\x11\n\tcategoria\x18\x05 \x01(\t\x12\x14\n\x0cingredientes\x18\x06 \x03(\t\x12\r\n\x05pasos\x18\x07 \x03(\t\x12\r\n\x05\x66otos\x18\x08 \x03(\t\x12\x16\n\x0eusuario_actual\x18\t \x01(\x05\" \n\x12RecetaPorIdRequest\x12\n\n\x02id\x18\x01 \x01(\x05\"Z\n\x11ResponseRecetaObj\x12#\n\x0crecetaObject\x18\x01 \x01(\x0b\x32\r.RecetaObject\x12 \n\x07mensaje\x18\x02 \x01(\x0b\x32\x0f.ResponseReceta\"\xa2\x01\n\x0cRecetaObject\x12\n\n\x02id\x18\x01 \x01(\x05\x12\x0e\n\x06titulo\x18\x02 \x01(\t\x12\x13\n\x0b\x64\x65scripcion\x18\x03 \x01(\t\x12\x1a\n\x12tiempo_preparacion\x18\x04 \x01(\x05\x12\x11\n\tcategoria\x18\x05 \x01(\t\x12\x14\n\x0cingredientes\x18\x06 \x03(\t\x12\r\n\x05pasos\x18\x07 \x03(\t\x12\r\n\x05\x66otos\x18\x08 \x03(\t\"^\n\x15ResponseRecetaObjList\x12#\n\x0crecetaObject\x18\x01 \x03(\x0b\x32\r.RecetaObject\x12 \n\x07mensaje\x18\x02 \x01(\x0b\x32\x0f.ResponseReceta\"\x07\n\x05\x45mpty\"\x9f\x01\n\x0cRecetaFiltro\x12\x11\n\tcategoria\x18\x01 \x01(\t\x12\x0e\n\x06titulo\x18\x02 \x01(\t\x12\x14\n\x0cingredientes\x18\x03 \x01(\t\x12\x14\n\x0ctiempo_desde\x18\x04 \x01(\x05\x12\x14\n\x0ctiempo_hasta\x18\x05 \x01(\x05\x12\x0f\n\x07\x61utorId\x18\x06 \x01(\x05\x12\x19\n\x11\x66\x61voritoUsuarioId\x18\x07 \x01(\x05\x32\xa2\x02\n\x06receta\x12.\n\x0b\x63rearReceta\x12\x0e.RecetaRequest\x1a\x0f.ResponseReceta\x12=\n\x10\x61\x63tualizarReceta\x12\x18.RecetaActualizarRequest\x1a\x0f.ResponseReceta\x12;\n\x10traerRecetaPorId\x12\x13.RecetaPorIdRequest\x1a\x12.ResponseRecetaObj\x12\x33\n\x11traerRecetasTodas\x12\x06.Empty\x1a\x16.ResponseRecetaObjList\x12\x37\n\x0etraerPorFiltro\x12\r.RecetaFiltro\x1a\x16.ResponseRecetaObjListB \n\x1c\x63om.unla.chefencasagrpc.grpcP\x01\x62\x06proto3')

_globals = globals()
_builder.BuildMessageAndEnumDescriptors(DESCRIPTOR, _globals)
_builder.BuildTopDescriptorsAndMessages(DESCRIPTOR, 'receta_pb2', _globals)
if _descriptor._USE_C_DESCRIPTORS == False:

  DESCRIPTOR._options = None
  DESCRIPTOR._serialized_options = b'\n\034com.unla.chefencasagrpc.grpcP\001'
  _globals['_RECETAREQUEST']._serialized_start=17
  _globals['_RECETAREQUEST']._serialized_end=192
  _globals['_RESPONSERECETA']._serialized_start=194
  _globals['_RESPONSERECETA']._serialized_end=227
  _globals['_RECETAACTUALIZARREQUEST']._serialized_start=230
  _globals['_RECETAACTUALIZARREQUEST']._serialized_end=427
  _globals['_RECETAPORIDREQUEST']._serialized_start=429
  _globals['_RECETAPORIDREQUEST']._serialized_end=461
  _globals['_RESPONSERECETAOBJ']._serialized_start=463
  _globals['_RESPONSERECETAOBJ']._serialized_end=553
  _globals['_RECETAOBJECT']._serialized_start=556
  _globals['_RECETAOBJECT']._serialized_end=718
  _globals['_RESPONSERECETAOBJLIST']._serialized_start=720
  _globals['_RESPONSERECETAOBJLIST']._serialized_end=814
  _globals['_EMPTY']._serialized_start=816
  _globals['_EMPTY']._serialized_end=823
  _globals['_RECETAFILTRO']._serialized_start=826
  _globals['_RECETAFILTRO']._serialized_end=985
  _globals['_RECETA']._serialized_start=988
  _globals['_RECETA']._serialized_end=1278
# @@protoc_insertion_point(module_scope)
