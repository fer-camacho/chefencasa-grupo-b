import React, { useState, useEffect } from "react";
import axios from "axios";
import Card from "react-bootstrap/Card";
import Button from "react-bootstrap/Button";
import imagen from "../img/wallpaper.jpg";
import Col from "react-bootstrap/Col";

function ListadoRecetas(listRecetas) {
  let estilo = {
    background: "hsla(0, 0%, 100%, 0.55)",
    backdropFilter: "blur(30px)",
    marginTop: "10px",
  };
  let estiloTitulo = {
    overflow: "hidden",
    whiteSpace: "nowrap",
    textOverflow: "ellipsis",
    maxWidth: "30px",
  };
  const recetas = listRecetas.recetas;
  console.log("RECETAS ListCardRecetas: " + JSON.stringify(recetas));

  //const recetas = [
  //  { id: 1, nombre: "NOMBRE1", descripcion: "DESCRIPCION demasiado largaDESCRIPCION demasiado largaDESCRIPCION demasiado largaDESCRIPCION demasiado largaDESCRIPCION demasiado largaDESCRIPCION demasiado largaDESCRIPCION demasiado largaDESCRIPCION demasiado largaDESCRIPCION demasiado larga DESCRIPCION demasiado larga DESCRIPCION demasiado larga DESCRIPCION demasiado larga", imagenUrl: imagen },
  //  { id: 2, nombre: "NOMBRE2NOMBRE2NOMBRE2NOMBRE2NOMBRE2NOMBRE2NOMBRE2NOMBRE2NOMBRE2NOMBRE2NOMBRE2NOMBRE2NOMBRE2NOMBRE2NOMBRE2", descripcion: "DESCRIPCION", imagenUrl: imagen },
  //  { id: 3, nombre: "NOMBRE3", descripcion: "DESCRIPCION", imagenUrl: imagen },
  //  { id: 4, nombre: "NOMBRE4", descripcion: "DESCRIPCION", imagenUrl: imagen },
  //  { id: 5, nombre: "NOMBRE5", descripcion: "DESCRIPCION", imagenUrl: imagen },
  //  { id: 6, nombre: "NOMBRE6", descripcion: "DESCRIPCION", imagenUrl: imagen },
  //];

  return (
    <>
      {recetas.map((receta, index) => (
        <Card key={index} className=" shadow" style={estilo}>
          <Card.Header as="h5">
            {" "}
            <div>{receta.titulo} </div>
          </Card.Header>
          <Card.Body style={{ backdropFilter: "blur(30px)" }}>
            <div className="d-flex ">
              <Card.Text className="">{receta.descripcion}</Card.Text>
              <Col />
              <div className="ml-auto">
                <img
                  src={receta.imagenUrl}
                  alt="Imagen de la receta"
                  width="100"
                  height="100"
                  className="rounded shadow"
                />
              </div>
            </div>
            <div className="d-flex ">
              <svg
                xmlns="http://www.w3.org/2000/svg"
                width="16"
                height="16"
                fill="currentColor"
                class="bi bi-clock"
                viewBox="0 0 16 16"
                style={{ marginTop: '5px', marginRight:"5px" }}
              >
                <path d="M8 3.5a.5.5 0 0 0-1 0V9a.5.5 0 0 0 .252.434l3.5 2a.5.5 0 0 0 .496-.868L8 8.71V3.5z" />
                <path d="M8 16A8 8 0 1 0 8 0a8 8 0 0 0 0 16zm7-8A7 7 0 1 1 1 8a7 7 0 0 1 14 0z" />
              </svg>
              <div>{receta.tiempoPreparacion}</div>
              <Col />
              <Button variant="primary">Ver receta</Button>
            </div>
          </Card.Body>
        </Card>
      ))}
    </>
  );
}

export default ListadoRecetas;
