import Container from "react-bootstrap/Container";
import Nav from "react-bootstrap/Nav";
import Navbar from "react-bootstrap/Navbar";
import Button from 'react-bootstrap/Button';
import Col from 'react-bootstrap/Col';
import React, { useContext, useEffect } from "react";
import UserContext from "../context/UserContext";

function NavBar() {
  const {user} = useContext(UserContext);
  console.log("ESTADO DE USUARIO LOGEADO :"+ JSON.stringify(user));
 // useEffect(()=>{
 //    console.log("ESTADO DE USUARIO LOGEADO :"+ JSON.stringify(user));
 // }, [user])
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
            <Button className="btn border-light" variant="secondary" href="/">Salir</Button>
            <Button className="btn border-light" variant="dark" href="/crearusuario">Ragistrarse</Button>
          
        </Container>
      </Navbar>
    </>
 return usuarioActivo ? logeado : visitante;
}

export default NavBar;
