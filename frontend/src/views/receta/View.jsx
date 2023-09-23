import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import Image from "react-bootstrap/Image";
import React, { useContext , useState, useEffect} from "react";
import UserContext from "../../context/UserContext";
import ListadoRecetas from "../../components/ListadoRecetas";
import ListadoFavoritas from "../../components/ListadoFavoritas";
import Receta from "../../components/Receta";
import FollowerFollowingTabs from "../../components/FollowerFollowingTabs";
import imgPerfil from "../../img/wallpaper.jpg";
import { useLocation } from "react-router-dom";
import UsuarioPerfil from "../../components/UsuarioPerfil";

function RecetaView() {
  const location = useLocation();
  const searchParams = new URLSearchParams(location.search);
  const id_receta = searchParams.get('recetaId');

  
  const [receta, setReceta] = useState(null);
  const { traerRecetaPorId } = useContext(UserContext);

  console.log("RECETA_ID: " + JSON.stringify(id_receta));

  useEffect(() => {
    if (id_receta) {
      traerRecetaPorId(id_receta)
        .then((msg) => {
          console.log("RECETAVIEW OBTENIDA:", msg);
          setReceta(msg.recetaObject);
        })
        .catch((error) => {
          console.error("Error al cargar el usuario:", error);
        });
    }
  }, [id_receta, traerRecetaPorId]);
  if (!receta) {
    return <p>Cargando receta...</p>;
  }
   
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
    marginBottom : "30px"
  }; 
  const estiloAside = {
    backgroundColor: "",
    justifyContent: "center",
    width: "20%",
  };
 
  return (
    <>
      <div style={estilo}>       
       {/*  <aside style={estiloAside}>
          <UsuarioPerfil key={Math.random()} usuario={usuario} />         
        </aside>  Ver el tema de traer el usuario*/}
        <section style={estiloSection}>
          <Receta key={Math.random()} receta={receta}/>      
        </section>
      
      </div>
    </>
  );
}

export default RecetaView;
