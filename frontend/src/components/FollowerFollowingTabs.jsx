import React from 'react';
import { Nav, Tab, Container, Row, Col } from 'react-bootstrap';
import ListadoSeguidores from "./ListadoSeguidores"

function FollowerFollowingTabs() {
    return (
        <Tab.Container id="follower-following-tabs" defaultActiveKey="followers">
          <Container>
            <Row>
              <Col sm={12}>
                <Nav variant="tabs" className="justify-content-center">
                  <Nav.Item>
                    <Nav.Link eventKey="followers">Seguidores</Nav.Link>
                  </Nav.Item>
                  <Nav.Item>
                    <Nav.Link eventKey="following">Siguiendo</Nav.Link>
                  </Nav.Item>
                </Nav>
              </Col>
            </Row>
            <Row>
              <Col sm={12}>
                <Tab.Content>
                  <Tab.Pane eventKey="followers">
                   <ListadoSeguidores/>
                  </Tab.Pane>
                  <Tab.Pane eventKey="following">
                    Contenido de la pestaña Siguiendo va aquí.
                  </Tab.Pane>
                </Tab.Content>
              </Col>
            </Row>
          </Container>
        </Tab.Container>
      );
}

export default FollowerFollowingTabs;
