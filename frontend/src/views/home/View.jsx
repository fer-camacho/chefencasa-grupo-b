import Container from "react-bootstrap/Container";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import React, { useContext } from "react";
import UserContext from "../../context/UserContext";
import ListRecetas from "../../components/ListRecetas";


function Home() {
  const { user } = useContext(UserContext);
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
              <ListRecetas></ListRecetas>
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
