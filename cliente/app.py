from flask import Flask, request
from flask_cors import CORS, cross_origin
from google.protobuf.json_format import MessageToJson
from grpcUsuarioCliente import UsuarioCliente

app = Flask(__name__)
CORS(app)

base_url_user = ""
base_url_vitual_wallet = ""#lo que se ponga acá se agrega al inicio de todas las urls

@app.route('/')
def hello():
    return "Service (OK)"

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


if __name__ == '__main__':
    app.run()