from flask import Flask, request
from flask_cors import CORS, cross_origin
from google.protobuf.json_format import MessageToJson
from grpcUsuarioCliente import UsuarioCliente
from grpcRecetaCliente import RecetaCliente

app = Flask(__name__)
CORS(app)

base_url_user = ""
base_url_vitual_wallet = ""#lo que se ponga acá se agrega al inicio de todas las urls

@app.route('/')
def hello():
    return "Service (OK)"

############## USUARIO

@app.route('/crearUsuario', methods=['POST'])
@cross_origin()
def saveProduct():
    user = UsuarioCliente()
    result = user.crearUsuario(request.json)
    return MessageToJson(result)


@app.route('/traerUsuarioPorId', methods=['GET'])
@cross_origin()
def findUserByUsername():
    user = UsuarioCliente()
    result = user.traerUsuarioPorId(request.json)
    return MessageToJson(result)


############## RECETA

@app.route('/crearReceta', methods=['POST'])
@cross_origin()
def crearReceta():
    receta = RecetaCliente()
    result = receta.crearReceta(request.json)
    return MessageToJson(result)

@app.route('/actualizarReceta', methods=['POST'])
@cross_origin()
def actualizarReceta():
    receta = RecetaCliente()
    result = receta.actualizarReceta(request.json)
    return MessageToJson(result)

@app.route('/traerReceta', methods=['GET'])
@cross_origin()
def traerReceta():
    receta = RecetaCliente()
    result = receta.traerRecetaPorId(request.json)
    return MessageToJson(result)

@app.route('/traerRecetas', methods=['GET'])
@cross_origin()
def traerRecetasTodas():
    receta = RecetaCliente()
    result = receta.traerRecetasTodas(request.json)
    return MessageToJson(result)

@app.route('/traerPorFiltro', methods=['GET'])
@cross_origin()
def traerPorFiltro():
    receta = RecetaCliente()
    result = receta.traerPorFiltro(request.json)
    return MessageToJson(result)


if __name__ == '__main__':
    app.run()