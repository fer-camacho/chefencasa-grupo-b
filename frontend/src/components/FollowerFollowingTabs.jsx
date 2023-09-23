import React,{ useContext , useState, useEffect} from 'react';
import UserContext from "../context/UserContext";
import { Nav, Tab, Container, Row, Col } from 'react-bootstrap';
import ListadoSeguidos from "./ListadoSeguidos"

function FollowerFollowingTabs({usuario}) {
  const [seguidos, setSeguidos] = useState([]);
  const {traerUsuariosSeguidos} = useContext(UserContext);

  console.log("FollowerFollowingTabs USUARIO: "+usuario.usuario.id)
  useEffect(()=>{
    traerUsuariosSeguidos(usuario.id).then((msg)=>{
      console.log("SEGUIDOS:" + JSON.stringify(msg.usuarioSeguidoObject));
      setSeguidos(msg.usuarioSeguidoObject);
    }).catch((error)=>{
      console.error("Error al cargar usuarios Seguidos:", error);
    });
  },[traerUsuariosSeguidos] );

// const user = {
//   id: 1,
//   nombre: 'Nombre del Usuario',
//   userName: 'NombreUsuario',
//   email: 'usuario@example.com',
//   password: 'contraseña',
// };
    return (
        <Tab.Container id="follower-following-tabs" defaultActiveKey="following">
          <Container>
            <Row>
              <Col sm={12}>
                <Nav variant="tabs" className="justify-content-center">
                  <Nav.Item>
                    <Nav.Link eventKey="followers" disabled>Seguidores</Nav.Link>
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
                  Seguidores, sin contenido.
                  </Tab.Pane>
                  <Tab.Pane eventKey="following">
                    {!seguidos ? <p>Sin Seguidos...</p> : <ListadoSeguidos seguidos={seguidos}/>}                              
                  </Tab.Pane>
                </Tab.Content>
              </Col>
            </Row>
          </Container>
        </Tab.Container>
      );
}

export default FollowerFollowingTabs;
