import Container from "react-bootstrap/Container";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import axios from "axios";
import React, { useContext , useState, useEffect} from "react";
import UserContext from "../../context/UserContext";
import ListCardRecetas from "../../components/ListCardRecetas";


function Home() {
  const { user, traerUsuarioPorId } = useContext(UserContext);
console.log("previo a la peticion");
const usuario = traerUsuarioPorId(2);
console.log("Pos peticion");

  return (
    <>      
      <section>
        <Container>
          <Row xs={1}>
            <h1> </h1>
          </Row>
          <Row xs={1}>
            <Col md={{ span: 3 }}></Col>

            <Col className="d-flex">
              <ListCardRecetas></ListCardRecetas>
            </Col>

            <Col md={{ span: 3 }}></Col>
          </Row>
          <Row xs={1}>
            <h1> </h1>
          </Row>
        </Container>
      </section>
    </>
  );
}

export default Home;
