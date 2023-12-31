import Container from "react-bootstrap/Container";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import Image from "react-bootstrap/Image";
import React, { useContext, useState, useEffect } from "react";
import UserContext from "../../context/UserContext";
import ListadoRecetas from "../../components/ListadoRecetas";
import ListadoFavoritas from "../../components/ListadoFavoritas";
import RecetasTabs from "../../components/RecetasTabs";
import FollowerFollowingTabs from "../../components/FollowerFollowingTabs";
import imgPerfil from "../../img/wallpaper.jpg";
import { redirect, useLocation } from "react-router-dom";
import UsuarioPerfil from "../../components/UsuarioPerfil";

function Usuario() {
  const location = useLocation();
  const searchParams = new URLSearchParams(location.search);
  const id = searchParams.get("user");

  const [usuario, setUsuario] = useState(null);
  const { traerUsuarioPorId } = useContext(UserContext);

  console.log("USER_ID: " + JSON.stringify(id));

  useEffect(() => {
    if (id) {
      traerUsuarioPorId(id)
        .then((msg) => {
          console.log("Usuario actualizado:", msg);
          setUsuario(msg.usuarioObject);
        })
        .catch((error) => {
          console.error("Error al cargar el usuario:", error);
        });
    }
  }, [id, traerUsuarioPorId]);
  if (!usuario) {
    return <p>Cargando usuario...</p>;
  }

  console.log("usuario Objeto:" + usuario);
  console.log("ID usuario.id" + usuario.id);

  const estilo = {
    display: "flex",
    backgroundColor: "",
    justifyContent: "center",
  };
  const estiloSection = {
    backgroundColor: "",
    justifyContent: "center",
    width: "60%",
    marginTop: "10px",
    marginBottom: "30px",
  };
  const estiloAside = {
    backgroundColor: "",
    justifyContent: "center",
    width: "20%",
  };

  return (
    <>
      <div style={estilo}>
        <aside style={estiloAside}>
          <UsuarioPerfil key={Math.random()} usuario={usuario} />
        </aside>
        <section style={estiloSection}>
          <RecetasTabs key={Math.random()} usuario={usuario} />
        </section>
      </div>
    </>
  );
}

export default Usuario;
