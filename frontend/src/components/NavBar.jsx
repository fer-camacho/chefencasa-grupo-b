import Container from "react-bootstrap/Container";
import Nav from "react-bootstrap/Nav";
import Navbar from "react-bootstrap/Navbar";
import Button from 'react-bootstrap/Button';
import Col from 'react-bootstrap/Col';

function NavBar() {
  const usuarioActivo = false;//usar el contexto de usuario
  const visitante = <>
  <Navbar bg="dark" data-bs-theme="dark">
    <Container>
      
        <Navbar.Brand href="/">CHEF EN CASA</Navbar.Brand>
        <Col ></Col>
        <Button variant="primary" href="/usuario">Usuario</Button>
        <Button variant="primary" href="/login">Ingresar</Button>
        <Button className="btn border-light" variant="dark" href="/crearusuario">Ragistrarse</Button>
      
    </Container>
  </Navbar>
</>
  const logeado =  <>
      <Navbar bg="dark" data-bs-theme="dark">
        <Container>          
            <Navbar.Brand href="/">CHEF EN CASA</Navbar.Brand>
            <Nav className="me-auto">
              <Nav.Link href="#RECETAS">Recetas</Nav.Link>
            </Nav>
            <Button className="btn border-light" variant="secondary" href="/login">Salir</Button>
            <Button className="btn border-light" variant="dark" href="/crearusuario">Ragistrarse</Button>
          
        </Container>
      </Navbar>
    </>
  if(usuarioActivo){
    return (logeado);} 
  return (visitante);
}

export default NavBar;
