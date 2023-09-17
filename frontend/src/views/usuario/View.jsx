import Container from "react-bootstrap/Container";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import Image from "react-bootstrap/Image";
import React, { useContext , useState, useEffect} from "react";
import UserContext from "../../context/UserContext";
import ListadoRecetas from "../../components/ListadoRecetas";
import ListadoFavoritas from "../../components/ListadoFavoritas";
import RecetasTabs from "../../components/RecetasTabs";
import FollowerFollowingTabs from "../../components/FollowerFollowingTabs";
import imgPerfil from "../../img/wallpaper.jpg";
import { redirect } from "react-router-dom";


  


function Usuario() {

const [usuario, setUsuario] = useState(null);
const { traerUsuarioPorId } = useContext(UserContext);

useEffect(() => {
 traerUsuarioPorId(1).then((msg) => {
      console.log("usuario a actualizar: "+ JSON.stringify(msg));
      setUsuario(msg.usuarioObject);
    })
    .catch((error) => {
      console.error("Error al cargar el usuario:", error);
    });
}, [traerUsuarioPorId]);
console.log("usuario :"+usuario );



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
 
  if (!usuario) {
    return <p>Cargando usuario...</p>;
  }


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
              <h1>{usuario.usuario}</h1>
            </Col>
            <Col>
              {" "}
              <h1>INFO:{" "} {usuario.email}</h1>
            </Col>
            <FollowerFollowingTabs usuario={usuario} />
          </div>
        </aside>
        <section style={estiloSection}>
          <RecetasTabs usuario={usuario}/>      
        </section>
      
      </div>
    </>
  );
}

export default Usuario;
