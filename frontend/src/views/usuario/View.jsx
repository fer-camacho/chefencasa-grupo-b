import Container from "react-bootstrap/Container";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import Image from "react-bootstrap/Image";
import React, { useContext } from "react";
import UserContext from "../../context/UserContext";
import ListadoRecetas from "../../components/ListadoRecetas";
import ListadoFavoritas from "../../components/ListadoFavoritas";
import RecetasTabs from "../../components/RecetasTabs";
import FollowerFollowingTabs from "../../components/FollowerFollowingTabs";
import imgPerfil from "../../img/wallpaper.jpg";
import { redirect } from "react-router-dom";

function Usuario() {
  const { user } = useContext(UserContext);
  const estilo = {
    display: "flex",
    backgroundColor: "",
    justifyContent: "center",
  };
  const estiloAside = {
    backgroundColor: "",
    justifyContent: "center",
    width: "20%",
  };
  const estiloSection = {
    backgroundColor: "",
    justifyContent: "center",
    width: "60%",
    marginTop: "10px",
    marginBottom : "30px"
  };
  const estiloPerfil = {
    backgroundColor: "",
    justifyContent: "center",
    alignItems: "center",
  };
  const estiloImgPerfil = {
    marginTop: "50px",
    width: 200,
    height: 200,
    borderStyle: "solid",
    border: "1px solid white",
  };
  //<img className="rounded-circle shadow" style={margin-top:50px} width="200" height="200" src={imgPerfil} />
  return (
    <>
      <div style={estilo}>
        <aside style={estiloAside}>
          <div style={estiloPerfil}>
            <Col>
              <img
                className="rounded-circle  "
                style={estiloImgPerfil}
                src={imgPerfil}
              />
            </Col>
            <Col>
              {" "}
              <h1>USERNAME</h1>
            </Col>
            <Col>
              {" "}
              <h1>INFO</h1>
            </Col>
            <FollowerFollowingTabs />
          </div>
        </aside>
        <section style={estiloSection}>
          <RecetasTabs />
          {/* <Col md={{ span: 3 }} className="contenedor"></Col>
        <Container >
          <Row xs={1}>
          <h1>MIS RECETAS </h1>
          </Row>
          <Row xs={1}>
            <Col className="  " >
              <ListadoRecetas></ListadoRecetas>
            </Col>
            <Col md={{ span: 3 }}></Col>
          </Row>
        </Container>*/}
        </section>
      {/*  <aside style={estiloAside}>
          <div style={estiloPerfil}>
            <Col>
              {" "}
              <h1>FAVORITAS</h1>
            </Col>
            <ListadoFavoritas />
          </div>
        </aside>*/}
      </div>
    </>
  );
}

export default Usuario;
