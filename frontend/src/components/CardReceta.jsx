import React from "react";
import { Button } from "react-bootstrap";
import Card from "react-bootstrap/Card";
import Col from "react-bootstrap/Col";

function CardReceta( {id, titulo, descripcion, img} ) {
  const estilo = {
    width: "18rem",
    background: "hsla(0, 0%, 100%, 0.55)",
    backdropFilter: "blur(30px)",
  };

  return (
    <>
      <Col>
        <Card className="card shadow" style={estilo}>
          <Card.Img className="card-img shadow rounded-top" variant="top" src={img} />
          <Card.Body>
            <Card.Title>{titulo}</Card.Title>
            <Card.Text>
              <div class="overflow-auto">{descripcion}</div>
            </Card.Text>
            <Button variant="primary">ID: {id}</Button>
          </Card.Body>
        </Card>
      </Col>
    </>
  );
}

export default CardReceta;
