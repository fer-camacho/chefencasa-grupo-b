import React from "react";
import { Link } from "react-router-dom";
import { Button } from "react-bootstrap";
import Card from "react-bootstrap/Card";
import Col from "react-bootstrap/Col";

function CardReceta( {receta} ) {
  const estilo = {
    width: "18rem",
    background: "hsla(0, 0%, 100%, 0.55)",
    backdropFilter: "blur(30px)",
  };

  return (
    <>
      <Col>
        <Card className="card shadow" style={estilo}>
          <Card.Img className="card-img shadow rounded-top" variant="top" src={"receta.fotos[0]"} />
          <Card.Body>
            <Card.Title>{receta.titulo}</Card.Title>
            <Card.Text>
              <div class="overflow-auto">{receta.descripcion}</div>
            </Card.Text>
            <Link to={`/receta?recetaId=${receta.id}`}>
                <Button variant="primary">Ver receta</Button>
              </Link>
          </Card.Body>
        </Card>
      </Col>
    </>
  );
}

export default CardReceta;
