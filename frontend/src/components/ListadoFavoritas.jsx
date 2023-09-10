import React, { useState, useEffect } from "react";
import axios from "axios";
import Card from "react-bootstrap/Card";
import Button from "react-bootstrap/Button";
import imagen from "../img/wallpaper.jpg";
import Col from "react-bootstrap/Col";

function ListadoFavoritas() {
  let estilo = {
    background: "hsla(0, 0%, 100%, 0.55)",
    backdropFilter: "blur(30px)",
    marginTop: "10px",
  };
  let estiloTitulo = {
    overflow: "hidden",
  whiteSpace: "nowrap",
  textOverflow: "ellipsis",
  maxWidth: "300px",
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
       <Card.Header as="h5"> <div >{receta.nombre} </div></Card.Header>
       <Card.Body style={{ backdropFilter: 'blur(30px)' }}>
         <div className="d-flex ">
           <Card.Text className="">{receta.descripcion}</Card.Text>
           <Col/>
           <div className="ml-auto" >
             <img
               src={receta.imagenUrl}
               alt="Imagen de la receta"
               width="100"
               height="100"
               className="rounded shadow"
             />
           </div>
         </div>
         <Button variant="primary">Ver receta</Button>
       </Card.Body>
     </Card>
      ))}
    </>
  );
}

export default ListadoFavoritas;
