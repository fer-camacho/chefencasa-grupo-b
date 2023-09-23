import React, { useState, useEffect } from "react";
import axios from "axios";
import Card from "react-bootstrap/Card";
import { Link } from "react-router-dom";
import Button from "react-bootstrap/Button";
import imagen from "../img/wallpaper.jpg";
import Col from "react-bootstrap/Col";

function ListadoSeguidos({seguidos}) {
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
  console.log("ListadoSeguidos: "+JSON.stringify(seguidos));  
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
                    src={"https://robohash.org/user"+seguidor.id}
                    alt="Imagen de la receta"
                    width="30"
                    height="30"
                    className="rounded-circle shadow"
                  />
                </div>
                <div style={estiloUsername}>   
                <Link to={`/usuario?user=${seguidor.id}`}>
                  {seguidor.usuario}{" "}</Link>
                </div>
                 {/*<Col />
               <Button variant="primary">Dejar</Button>*/} 
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
