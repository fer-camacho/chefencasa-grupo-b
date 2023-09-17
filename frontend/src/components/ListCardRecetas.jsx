import Container from "react-bootstrap/Container";
import Button from "react-bootstrap/Button";
import Card from "react-bootstrap/Card";
import { Row } from "react-bootstrap";
import Col from "react-bootstrap/Col";
import CardReceta from "./CardReceta";
import imagen from "../img/wallpaper.jpg";
import imagen1 from "../img/portada.webp";

//Datos de prueba
const recetas = [
  { id: 1,img:imagen, titulo: "TITULO1", descripcion: "DESCRIPCION" },
  { id: 1,img:imagen1, titulo: "TITULO", descripcion: "DESCRIPCION" },
  { id: 1,img:imagen, titulo: "TITULO", descripcion: "DESCRIPCION es una descripcion larga DESCRIPCIONDESCRIPCION es una descripcion larga DESCRIPCIONDESCRIPCION es una descripcion larga DESCRIPCION es una descripcion larga DESCRIPCION es una descripcion larga DESCRIPCION es una descripcion larga" },
  { id: 1,img:imagen, titulo: "TITULO", descripcion: "DESCRIPCION" },
  { id: 1,img:imagen1, titulo: "TITULO", descripcion: "DESCRIPCION" },
  { id: 1,img:imagen1, titulo: "TITULO", descripcion: "DESCRIPCION es una descripcion larga DESCRIPCION es una descripcion larga" },
  { id: 1,img:imagen1, titulo: "TITULO", descripcion: "DESCRIPCION" }
];

function ListCardRecetas() {
  let estilo = {padding:'1% 1%'}
  

  return (
    <>
      <Container
        className="container d-flex justify-content-center align-items-center h-100"
        fluid="true"
      >
        {/**/}{" "}
        <Row>
          {recetas.map((cardReceta, index) => (
            <Col key={index} style={estilo}>
              <CardReceta
                id={cardReceta.id}
                titulo={cardReceta.titulo}
                descripcion={cardReceta.descripcion}
                img={cardReceta.img}
              ></CardReceta>
            </Col>
          ))}
        </Row>
      </Container>
    </>
  );
}

export default ListCardRecetas;
