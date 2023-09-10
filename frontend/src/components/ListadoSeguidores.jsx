import React, { useState, useEffect } from "react";
import axios from "axios";
import Card from "react-bootstrap/Card";
import Button from "react-bootstrap/Button";
import imagen from "../img/wallpaper.jpg";
import Col from "react-bootstrap/Col";

function ListadoSeguidores() {
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
  //   const [recetas, setRecetas] = useState([]);
  //
  // useEffect(() => {
  //   async function fetchRecetas() {
  //     try {
  //       const response = await axios.get(`http://127.0.0.1:5000/traerRecetasPorFiltro?userId=${userId}`);
  //       // Suponiendo que la respuesta contiene un array de objetos de recetas
  //       setRecetas(response.data);
  //     } catch (error) {
  //       console.error('Error al obtener las recetas:', error);
  //     }
  //   }
  //
  //   fetchRecetas();
  // }, [userId]);
  const recetas = [
    {
      id: 1,
      nombre: "NOMBRE1NOMBRE1NOMBRE1NOMBRE1NOMBRE1NOMBRE1",
      descripcion:
        "DESCRIPCION demasiado largaDESCRIPCION demasiado largaDESCRIPCION demasiado largaDESCRIPCION demasiado largaDESCRIPCION demasiado largaDESCRIPCION demasiado largaDESCRIPCION demasiado largaDESCRIPCION demasiado largaDESCRIPCION demasiado larga DESCRIPCION demasiado larga DESCRIPCION demasiado larga DESCRIPCION demasiado larga",
      imagenUrl: imagen,
    },
    { id: 2, nombre: "NOMBRE2", descripcion: "DESCRIPCION", imagenUrl: imagen },
    { id: 3, nombre: "NOMBRE3", descripcion: "DESCRIPCION", imagenUrl: imagen },
    { id: 4, nombre: "NOMBRE4", descripcion: "DESCRIPCION", imagenUrl: imagen },
    { id: 5, nombre: "NOMBRE5", descripcion: "DESCRIPCION", imagenUrl: imagen },
    { id: 6, nombre: "NOMBRE6", descripcion: "DESCRIPCION", imagenUrl: imagen },
  ];

  return (
    <>
      {recetas.map((receta, index) => (
        <Card key={index} className=" shadow" style={estilo}>
          <Card.Header as="h5">
            {" "}
            <div className="d-flex ">
              <div className="ml-auto">
                <img
                  src={receta.imagenUrl}
                  alt="Imagen de la receta"
                  width="30"
                  height="30"
                  className="rounded-circle shadow"
                />
              </div>
              <div style={estiloUsername}>
              {receta.nombre} </div>
              <Col/>
              <Button variant="primary">Dejar</Button>
            </div>
          </Card.Header>
        </Card>
      ))}
    </>
  );
}

export default ListadoSeguidores;
