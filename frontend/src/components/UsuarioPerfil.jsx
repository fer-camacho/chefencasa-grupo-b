
import FollowerFollowingTabs from "./FollowerFollowingTabs";
import Col from "react-bootstrap/Col";
function UsuarioPerfil({usuario}){
   
    const imagenUser="https://robohash.org/user"+usuario.id;   
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
return ( <div style={estiloPerfil}>
    <Col>
      <img
        className="rounded-circle  "
        style={estiloImgPerfil}
        src={imagenUser}
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
  </div>);
}
export default UsuarioPerfil;