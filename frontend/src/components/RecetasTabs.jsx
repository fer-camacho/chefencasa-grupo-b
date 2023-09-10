import React from 'react';
import { Nav, Tab, Container, Row, Col } from 'react-bootstrap';
import ListadoRecetas from "./ListadoRecetas";
import ListadoFavoritas from "./ListadoFavoritas";

function RecetasTabs() {
    return (
        <Tab.Container id="recetas-tabs" defaultActiveKey="recetas">
          <Container>
            <Row>
              <Col sm={12}>
                <Nav variant="tabs" className="justify-content-center">
                  <Nav.Item>
                    <Nav.Link eventKey="recetas">Recetas</Nav.Link>
                  </Nav.Item>
                  <Nav.Item>
                    <Nav.Link eventKey="favoritas">Favoritas</Nav.Link>
                  </Nav.Item>
                </Nav>
              </Col>
            </Row>
            <Row>
              <Col sm={12}>
                <Tab.Content>
                  <Tab.Pane eventKey="recetas">
                   <ListadoRecetas/>
                  </Tab.Pane>
                  <Tab.Pane eventKey="favoritas">
                   <ListadoFavoritas/>
                  </Tab.Pane>
                </Tab.Content>
              </Col>
            </Row>
          </Container>
        </Tab.Container>
      );
}

export default RecetasTabs;
