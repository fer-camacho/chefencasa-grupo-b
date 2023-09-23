import Container from "react-bootstrap/Container";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import axios from "axios";
import React, { useContext , useState, useEffect} from "react";
import UserContext from "../../context/UserContext";
import ListCardRecetas from "../../components/ListCardRecetas";


function Home() {
  const { user, traerUsuarioPorId , traerRecetas} = useContext(UserContext);
const [recetas, setRecetas] = useState(null);

//console.log("Pos peticion");
useEffect(() => {  
  traerRecetas()
      .then((msg) => {
        console.log("RECETAS HOME:", msg);
        setRecetas(msg.recetaObject);
      })
      .catch((error) => {
        console.error("Error al cargar el usuario:", error);
      });
}, [ traerRecetas]);
if (!recetas) {
  return <p>Cargando recetas...</p>;
}
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
              <ListCardRecetas  key={Math.random()} recetas={recetas}></ListCardRecetas>
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
