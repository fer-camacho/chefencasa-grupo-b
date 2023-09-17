import React, { useState, useEffect } from "react";
import axios from "axios";
import Card from "react-bootstrap/Card";
import Button from "react-bootstrap/Button";
import imagen from "../img/wallpaper.jpg";
import Col from "react-bootstrap/Col";

function ListadoSeguidos(user) {
  let estilo = {
    background: "hsla(0, 0%, 100%, 0.55)",
    backdropFilter: "blur(30px)",
    marginTop: "10px",
  };
  let estiloUsername = {
    overflow: "hidden",
    whiteSpace: "nowrap",
    textOverflow: "ellipsis",
    maxWidth: "200px",
    marginLeft: "10px"
  };
  console.log(user);
  async function TraerSeguidos(user) {
    try {
      // Realiza la solicitud POST al servidor
      const response = await axios.post('http://127.0.0.1:5000/traerUsuariosSeguidos', user);
  
      // Extrae los datos de la respuesta
      const seguidos = response.data;
  
      // Ahora puedes usar la variable 'seguidos' en tu componente React
      console.log("Usuarios seguidos:", seguidos);
  
      return seguidos;
    } catch (error) {
      console.error("Error al obtener usuarios seguidos:", error);
      throw error; // Puedes manejar el error según tus necesidades
    }
  };

  // Declare una variable de estado para almacenar los seguidos
  const [seguidos, setSeguidos] = useState([]);

  // Llame a la función para obtener seguidos cuando el componente se monte
  useEffect(() => {
    async function obtenerSeguidos() {
      const seguidos = await TraerSeguidos(user);
      setSeguidos(seguidos);
    }
    obtenerSeguidos();
  }, [user]);
  
  return (
    <>
      {seguidos.length > 0 ? (
        seguidos.map((seguidor, index) => (
          <Card key={index} className=" shadow" style={estilo}>
            <Card.Header as="h5">
              {" "}
              <div className="d-flex ">
                <div className="ml-auto">
                  <img
                    src={seguidor.imagenUrl}
                    alt="Imagen de la receta"
                    width="30"
                    height="30"
                    className="rounded-circle shadow"
                  />
                </div>
                <div style={estiloUsername}>
                  {seguidor.username}{" "}
                </div>
                <Col />
                <Button variant="primary">Dejar</Button>
              </div>
            </Card.Header>
          </Card>
        ))
      ) : (
        <p>No hay seguidores disponibles.</p>
      )}
    </>
  );
}

export default ListadoSeguidos;
