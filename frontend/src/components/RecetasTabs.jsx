import React, { useContext , useState, useEffect} from "react";
import UserContext from "../context/UserContext";
import { Nav, Tab, Container, Row, Col } from "react-bootstrap";
import ListadoRecetas from "./ListadoRecetas";
import ListadoFavoritas from "./ListadoFavoritas";

function RecetasTabs(usuario) {
  console.log("RecetasTab USER: " + JSON.stringify(usuario));
  console.log("RecetasTab USER1: " + usuario.usuario.id);
  const [recetas, setRecetas] = useState(null);
  const [favoritas, setFavoritas] = useState(null);
  const { traerRecetasPorFiltro } = useContext(UserContext);
 // const filtro = {
 //   categoria: null,
 //   titulo: null,
 //   ingredientes: null,
 //   tiempoDesde: null,
 //   tiempoHasta: null,
 //   autorId: usuario.usuario.id,
 //   favoritoUsuarioId: null,
 // };
  useEffect(() => {
    traerRecetasPorFiltro(null, null, null, null, null,usuario.usuario.id, null)
      .then((msg) => {
        console.log("Recetas por filtro obtenidas: " + JSON.stringify(msg));
        setRecetas(msg.recetaObject);
      })
      .catch((error) => {
        console.error("Error al cargar recetas del usuario:", error);
      });

      traerRecetasPorFiltro(null, null, null, null, null, null,usuario.usuario.id)
      .then((msg) => {
        console.log("Recetas por filtro obtenidas: " + JSON.stringify(msg));
        setFavoritas(msg.recetaObject);
      })
      .catch((error) => {
        console.error("Error al cargar favoritas del usuario:", error);
      });

  }, [traerRecetasPorFiltro]);
 //console.log("ListaRecetas: "+recetas2[1].id);
 //console.log("ListaRecetas: "+JSON.stringify(recetas2));

 // const recetas = true;
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
                {!recetas ? (
                  <p>Sin recetas ...</p>
                ) : (
                  console.log("Estado previo de RECETAS: "+ JSON.stringify(recetas)),
                  <ListadoRecetas recetas={recetas} />
                )}
              </Tab.Pane>
              <Tab.Pane eventKey="favoritas">
              {!favoritas ? (
                  <p>Sin recetas ...</p>
                ) : (
                  console.log("Estado previo de RECETAS Favoritas: "+ JSON.stringify(favoritas)),
                  <ListadoFavoritas recetas={favoritas} />
                )}
              </Tab.Pane>
            </Tab.Content>
          </Col>
        </Row>
      </Container>
    </Tab.Container>
  );
}

export default RecetasTabs;
