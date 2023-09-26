from flask import Flask, request
from flask_cors import CORS, cross_origin
from google.protobuf.json_format import MessageToJson
from grpcUsuarioCliente import UsuarioCliente
from grpcRecetaCliente import RecetaCliente

app = Flask(__name__)
CORS(app)

@app.route('/')
def hello():
    return "Service (OK)"

############## USUARIO

@app.route('/crearUsuario', methods=['POST'])
@cross_origin()
def crearUsuario():
    user = UsuarioCliente()
    result = user.crearUsuario(request.json)
    return MessageToJson(result)


@app.route('/traerUsuarioPorId/<int:user_id>', methods=['GET'])
@cross_origin()
def traerUsuarioPorId(user_id):
    user = UsuarioCliente()
    result = user.traerUsuarioPorId({'id': user_id})
    return MessageToJson(result)

@app.route('/traerRecetasFavoritas', methods=['GET'])
@cross_origin()
def traerRecetasFavoritas():
    user = UsuarioCliente()
    result = user.traerRecetasFavoritas(request.json)
    return MessageToJson(result)

@app.route('/marcarRecetaFavorita', methods=['POST'])
@cross_origin()
def marcarRecetaFavorita():
    user = UsuarioCliente()
    result = user.marcarRecetaFavorita(request.json)
    return MessageToJson(result)

@app.route('/seguirUsuario', methods=['POST'])
@cross_origin()
def seguirUsuario():
    user = UsuarioCliente()
    result = user.seguirUsuario(request.json)
    return MessageToJson(result)

@app.route('/traerUsuariosSeguidos/<int:user_id>', methods=['GET'])
@cross_origin()
def traerUsuariosSeguidos(user_id):
    user = UsuarioCliente()
    result = user.traerUsuariosSeguidos({'id': user_id})
    return MessageToJson(result)

@app.route('/obtenerUsuario', methods=['GET'])
@cross_origin()
def obtenerUsuario():
    user = UsuarioCliente()
    result = user.obtenerUsuario(request.json)
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

@app.route('/traerReceta/<int:recetaId>', methods=['GET'])
@cross_origin()
def traerReceta(recetaId):
    receta = RecetaCliente()
    result = receta.traerRecetaPorId({'id': recetaId})
    return MessageToJson(result)

@app.route('/traerRecetas', methods=['GET'])
@cross_origin()
def traerRecetasTodas():
    receta = RecetaCliente()
    result = receta.traerRecetasTodas({''})
    return MessageToJson(result)
"""
@app.route('/traerPorFiltro', methods=['GET'])
@cross_origin()
def traerPorFiltro():
    # Extract parameters from the query string
    categoria = request.args.get('categoria', '')
    titulo = request.args.get('titulo', '')
    ingredientes = request.args.get('ingredientes', '')

    tiempo_desde_str = request.args.get('tiempo_desde', '')
    tiempo_desde = int(tiempo_desde_str) if tiempo_desde_str else 0
    
    tiempo_hasta_str = request.args.get('tiempo_hasta', '')
    tiempo_hasta = int(tiempo_hasta_str) if tiempo_hasta_str else 0

    autorId_str = request.args.get('autorId', '')
    autorId = int(autorId_str) if autorId_str else 0

    favoritoUsuarioId_str = request.args.get('favoritoUsuarioId', '')
    favoritoUsuarioId = int(favoritoUsuarioId_str) if favoritoUsuarioId_str else 0

    # Create a dictionary with the parameters
    receta1 = {
        'categoria': categoria,
        'titulo': titulo,
        'ingredientes': ingredientes,
        'tiempo_desde': tiempo_desde,
        'tiempo_hasta': tiempo_hasta,
        'autorId': autorId,
        'favoritoUsuarioId': favoritoUsuarioId
    }
    print(receta1)
    receta = RecetaCliente()
    #result = receta.traerPorFiltro(receta1)
    result = receta.traerPorFiltro(request.json)
    return MessageToJson(result)

"""
@app.route('/traerPorFiltro', methods=['GET'])
@cross_origin()
def traerPorFiltro():
    receta = RecetaCliente()
    result = receta.traerPorFiltro(request.json)
    print(request.json)
    return MessageToJson(result)

if __name__ == '__main__':
    app.run()